package com.mcm.api.controller;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcm.api.dto.request.RemoveTeamRequestBody;
import com.mcm.api.dto.response.ErrorResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.entity.CaseTeamMapping;
import com.mcm.api.entity.Cases;
import com.mcm.api.repository.CaseRepository;
import com.mcm.api.repository.CaseTeamMappingRepository;
import com.mcm.api.services.CaseService;


@RestController
public class CaseController {

	@Autowired
	CaseService caseService;

	@GetMapping("/caseList")
	public ResponseEntity<String> getCases() throws JSONException {
		return new ResponseEntity(caseService.getCases(), HttpStatus.OK) ;
	}

	@PostMapping("/caseByuser")
	public ResponseEntity<String> getCasesByUser(@RequestBody Map<String, String> json) throws JSONException {
		return new ResponseEntity(caseService.getCasesByUser(json.get("userid")), HttpStatus.OK) ;
	}

	@PostMapping("/caseBydepartmentid")
	public ResponseEntity<String> getCasesByDepartmentId(@RequestBody Map<String, String> json) throws JSONException {
		return new ResponseEntity(caseService.getCasesByDepartmentId(json.get("departid")), HttpStatus.OK) ;
	}
	
	@GetMapping("/caseBydepartment")
	public ResponseEntity<String> groupByDepartment() throws JSONException {
		return new ResponseEntity(caseService.groupByDepartment(), HttpStatus.OK) ;
	}
	
	@PostMapping("/caseInsert")
	public ResponseEntity<String> caseInsert(@RequestBody Map<String, Object> json) throws JSONException {
		return new ResponseEntity(caseService.caseInsert(json), HttpStatus.OK) ;
	}
	
	@PostMapping("/teamDisable")
	public ResponseEntity removeTeam(@RequestBody RemoveTeamRequestBody request){
		return new ResponseEntity(caseService.removeTeam(request), HttpStatus.OK) ;
		
	}

	@GetMapping("/dashboard")
	public ResponseEntity<String> dashboard() throws JSONException{
		return new ResponseEntity(caseService.dashboard(), HttpStatus.OK) ;
	}
	
	@PostMapping("/caseClose")
	public ResponseEntity<String> caseClose(@RequestBody Map<String, String> json) throws JSONException {
		return new ResponseEntity(caseService.caseClose(json.get("caseid")), HttpStatus.OK) ;
	}

}
