package com.mcm.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcm.api.dto.request.CreateNewDepartmentRequestDto;
import com.mcm.api.dto.request.GetTeamByDepartmentRequestDto;
import com.mcm.api.dto.response.GetAllLeadersResponseDto;
import com.mcm.api.dto.response.GetDepartmentListResponseDto;
import com.mcm.api.dto.response.GetTeamByDepartmentResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.entity.DepTeamMapping;
import com.mcm.api.entity.Department;
import com.mcm.api.entity.Team;
import com.mcm.api.entity.TeamUserMapping;
import com.mcm.api.repository.DepartmentRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	@GetMapping("/departmentList")
	public ResponseEntity getDepartmentList() {
		Iterable<Department> deptItr = departmentRepo.findAll();
		List<GetDepartmentListResponseDto> result = 
				  StreamSupport.stream(deptItr.spliterator(), false).map(GetDepartmentListResponseDto::new)
				    .collect(Collectors.toList());
		return new ResponseEntity(result, HttpStatus.OK) ;
		
	}
	
	@PostMapping("/departmentInsert")
	public ResponseEntity createUser(@RequestBody CreateNewDepartmentRequestDto req) {
		Department d = new Department();
		d.setDepartment(req.getDepartment());
		departmentRepo.save(d);
		return new ResponseEntity(new SuccessResponseDto("success"), HttpStatus.OK) ;
	}
	
	@GetMapping("/teamBydepartment")
	public ResponseEntity getTeamByDepartment(@RequestBody GetTeamByDepartmentRequestDto req) {
		Iterable<Department> departments = departmentRepo.findAllById(req.getDepartmentid());
		List<GetTeamByDepartmentResponseDto> result = 
				StreamSupport.stream(departments.spliterator(), false)
				.map(dp->dp.getDepTeamMappings()).flatMap(List::stream)
				.map(DepTeamMapping::getTeam)
				.map(GetTeamByDepartmentResponseDto::new).collect(Collectors.toList());		
		return new ResponseEntity(result, HttpStatus.OK) ;
	}
}
