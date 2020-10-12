package com.mcm.api.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import com.google.gson.Gson;
import com.mcm.api.dto.request.RemoveTeamRequestBody;
import com.mcm.api.dto.response.ErrorResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.dto.response.cases.CaseListByDepartmentResponseDto;
import com.mcm.api.dto.response.cases.CaseListResponseDto;
import com.mcm.api.entity.CaseTeamMapping;
import com.mcm.api.entity.Cases;
import com.mcm.api.entity.Team;
import com.mcm.api.entity.TeamUserMapping;
import com.mcm.api.entity.User;
import com.mcm.api.repository.CaseRepository;
import com.mcm.api.repository.CaseTeamMappingRepository;
import com.mcm.api.repository.TeamRepository;
import com.mcm.api.repository.UserRepository;

@Service
public class CaseService {
	@Autowired
	CaseRepository caseRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	CaseTeamMappingRepository caseTeamMappingRepository;

	public CaseService() {

	}

	public String getCases() throws JSONException {
		Iterable<Cases> cases = caseRepository.findAll();

		return generateResponse(cases);
	}

	public String getCasesByUser(String userId) throws JSONException {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			return "{}";
		}

		List<TeamUserMapping> teamUserMappings = user.get().getTeamUserMappings();

		List<Cases> cases = new ArrayList<>();



		for(TeamUserMapping teamUserMapping: teamUserMappings) {
			Team team = teamUserMapping.getTeam();
			List<CaseTeamMapping> caseTeamMapping = team.getCaseTeamMappings();
			for(CaseTeamMapping caseTeamMappingObj: caseTeamMapping) {
				cases.add(caseTeamMappingObj.getCases());
			}
		}


		return generateResponse(cases);
	}

	public String getCasesByDepartmentId(String departmentId) throws JSONException {
		List<Cases> cases = caseRepository.findByDepartmentid(departmentId);

		return generateResponse(cases);
	}

	public String groupByDepartment() {
		List<Object> casesByDepartment = caseRepository.findByDepartment();

		HashMap<String, List<Object>> map = new HashMap<>();

		for(Object case_: casesByDepartment) {
			Object caseInfo[] =  (Object[]) case_;
			String key = (String) caseInfo[1];
			CaseListByDepartmentResponseDto caseResponseObj = new CaseListByDepartmentResponseDto(case_);
			if(map.containsKey(key)) {
				map.get(key).add(caseResponseObj);
				continue;
			}

			ArrayList<Object> caseList = new ArrayList<>();
			caseList.add(caseResponseObj);
			map.put((String) caseInfo[1], caseList);
		}

		Gson gson = new Gson();

		return gson.toJson(map);
	}

	public String generateResponse(Iterable<Cases> cases) throws JSONException {
		List<CaseListResponseDto> caseListResponses = 
				StreamSupport.stream(cases.spliterator(), false).map(CaseListResponseDto::new)
				.collect(Collectors.toList());

		JSONObject responseObj = new JSONObject();
		Gson gson = new Gson();
		for(CaseListResponseDto caseListResponse: caseListResponses) {
			JSONArray responseArray = new JSONArray();
			responseArray.put(new JSONObject(gson.toJson(caseListResponse)));
			responseObj.put(caseListResponse.getId(), responseArray);
		}

		return responseObj.toString();
	}

	@Transactional
	public String caseInsert(Map<String, Object> caseBody) throws JSONException {
		Cases case_ = new Cases();

		case_.setCname((String)caseBody.get("casename"));
		case_.setCasetype((String)caseBody.get("casetype"));
		case_.setDescription((String)caseBody.get("discription"));
		case_.setDepartmentid((String)caseBody.get("deptid"));
		case_.setDuedate(new BigDecimal((String)caseBody.get("duedate")));
		case_.setStatus("Active");

		ArrayList<String> teamIds =  (ArrayList<String>)caseBody.get("teams");	

		Iterable<Team> teams = teamRepository.findAllById(teamIds);

		List<Team> teamList = 
				StreamSupport.stream(teams.spliterator(), false)
				.collect(Collectors.toList());


		String gid = UUID.randomUUID().toString().replace("-", "");
		String pid = UUID.randomUUID().toString().replace("-", "");

		case_.setId(gid);
		case_.setPid(pid);

		caseRepository.save(case_);

		for(Team team: teamList) {
			CaseTeamMapping caseTeamMapping = new CaseTeamMapping(team,case_, "Active");

			caseTeamMappingRepository.save(caseTeamMapping);
		}

		JSONObject response = new JSONObject();
		response.put("code", "success");

		return response.toString();
	}

	public String dashboard() throws JSONException {
		Iterable<Cases> allCases = caseRepository.findAll();

		Map<String, Long> casesCountMap = 
				StreamSupport.stream(allCases.spliterator(), false).collect(Collectors.groupingBy(Cases::getStatus, Collectors.counting()));

		int dueCount = caseRepository.countByStatusAndDuedateLessThan("Active",new BigDecimal(System.currentTimeMillis()));


		JSONArray responseArray = new JSONArray();
		JSONObject responseObj = new JSONObject();
		for(Entry<String, Long> statusSet: casesCountMap.entrySet()) {
			JSONArray statusArray = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("STATUS", statusSet.getKey());
			obj.put("VALUE", statusSet.getValue());
			statusArray.put(obj);
			responseObj.put(statusSet.getKey(), statusArray);
		}

		if(dueCount>0) {

			JSONArray statusArray = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("VALUE", dueCount);
			statusArray.put(obj);
			responseObj.put("others", statusArray);
		}
		return responseObj.toString();
	}

	public String removeTeam(RemoveTeamRequestBody request) {
		Optional<Cases> case_ = caseRepository.findById(request.getCaseid());
		Optional<Team> team = teamRepository.findById(request.getTeamid());

		if(case_.isPresent() && team.isPresent()) {
			CaseTeamMapping cases = caseTeamMappingRepository.findByCasesAndTeam(case_.get(),team.get());
			if(cases != null) {
				cases.setStatus("Close");
				caseTeamMappingRepository.save(cases);
			}
			return new SuccessResponseDto("success").toString();
		} 
		return new ErrorResponseDto("case id not found").toString();

	}

}
