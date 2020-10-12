package com.mcm.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mcm.api.dto.response.cases.CaseListResponseDto;
import com.mcm.api.entity.Cases;
import com.mcm.api.entity.Team;
import com.mcm.api.entity.TeamUserMapping;
import com.mcm.api.entity.User;
import com.mcm.api.repository.CaseRepository;
import com.mcm.api.repository.UserRepository;

@Service
public class CaseService {
	@Autowired
	CaseRepository caseRepository;
	
	@Autowired
	UserRepository userRepository;
	
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
			cases.addAll(teamUserMapping.getTeam().getCases());
		}
		
		
		return generateResponse(cases);
	}
	
	public String getCasesByDepartmentId(String departmentId) throws JSONException {
		List<Cases> cases = caseRepository.findByDepartmentid(departmentId);
		
		return generateResponse(cases);
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
}
