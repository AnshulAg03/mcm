package com.mcm.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcm.api.dto.request.CreateNewTeamRequestDto;
import com.mcm.api.dto.request.UpdateTeamRequestDto;
import com.mcm.api.dto.request.isLeaderRequestDto;
import com.mcm.api.dto.response.ErrorResponseDto;
import com.mcm.api.dto.response.GetAllLeadersResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.dto.response.TeamListResponseDto;
import com.mcm.api.dto.response.isLeaderResponseDto;
import com.mcm.api.entity.Department;
import com.mcm.api.entity.Team;
import com.mcm.api.entity.TeamUserMapping;
import com.mcm.api.entity.User;
import com.mcm.api.repository.DepartmentRepository;
import com.mcm.api.repository.TeamRepository;
import com.mcm.api.repository.TeamUserMappingRepository;
import com.mcm.api.repository.UserRepository;

@RestController
public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TeamUserMappingRepository teamUserMappingRepository;
	
	@Autowired
	DepartmentRepository departmentRepo;

	@GetMapping("/teamList")
	public ResponseEntity getTeams() {
		Iterable<Team> teams = teamRepository.findAll();
		List<Team> teamList = 
				StreamSupport.stream(teams.spliterator(), false).collect(Collectors.toList());
		List<List<TeamListResponseDto>> teamUserMapping = teamList.stream().map(team-> team.getTeamUserMappings().
				stream().map(TeamListResponseDto::new).collect(Collectors.toList())).collect(Collectors.toList());
		Map<String, List<TeamListResponseDto>> result= teamUserMapping.stream().flatMap(List::stream)
		        .collect(Collectors.groupingBy(TeamListResponseDto::getTEAMID,
				Collectors.toCollection(ArrayList::new)));
		
		return new ResponseEntity(result, HttpStatus.OK) ;
	}

	@PostMapping("/teamInsert")
	public ResponseEntity createUser(@RequestBody CreateNewTeamRequestDto request) {

		Iterable<User> users = userRepository.findAllById(request.getTeamMembers());
		List<User> user = StreamSupport.stream(users.spliterator(), false)
				.collect(Collectors.toList());
		Team team = new Team(request);
		teamRepository.save(team);
		List<TeamUserMapping> teamUserMappings= new ArrayList<TeamUserMapping>();

		for(User u:user) {
			teamUserMappings.add(new TeamUserMapping(team,u,request.getIsAdmin()));
		}

		teamUserMappingRepository.saveAll(teamUserMappings);

		return new ResponseEntity<>(new SuccessResponseDto("success"), HttpStatus.OK);
	}
	
	@PostMapping("/teamEdit")
	public ResponseEntity editTeam(@RequestBody UpdateTeamRequestDto request) {

		Optional<Team> team = teamRepository.findById(request.getTeamId());
		if(team.isPresent()) {
			Team t = team.get();
			t.setName(request.getTeamName());
			t.setDescription(request.getDescription());
			List<Department> deptList = new ArrayList<Department>();
			Optional<Department> d = departmentRepo.findById(request.getDepartment());
			if(d.isPresent()) {
				Department dept = d.get();
				deptList.add(dept);
			}
			t.setDepartments(deptList);
			teamRepository.save(t);
			
			return new ResponseEntity<>(new SuccessResponseDto("success"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto("Team doesn't exist"), HttpStatus.OK);
	}
	
	@GetMapping("/isleader")
	public ResponseEntity fetchLeader(@RequestBody isLeaderRequestDto request) {

		Optional<User> user = userRepository.findById(request.getUserid());
		if(!user.isPresent()) {
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		Iterable<TeamUserMapping> teamUsers = teamUserMappingRepository.findAllByUser(user.get());
		List<isLeaderResponseDto> result = StreamSupport.stream(teamUsers.spliterator(), false).map(TeamUserMapping::getTeam).map(isLeaderResponseDto::new)
				.collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/isLeaderall")
	public ResponseEntity getAllLeaders() {
		Iterable<TeamUserMapping> teams = teamUserMappingRepository.findAll();
		List<GetAllLeadersResponseDto> result = 
				StreamSupport.stream(teams.spliterator(), false).filter(tum->tum.getUser()!=null).map(GetAllLeadersResponseDto::new).collect(Collectors.toList());
		
		return new ResponseEntity(result, HttpStatus.OK) ;
	}
	
	
}
