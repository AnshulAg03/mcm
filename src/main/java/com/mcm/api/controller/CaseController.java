package com.mcm.api.controller;

import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
