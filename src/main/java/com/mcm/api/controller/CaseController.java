package com.mcm.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mcm.api.dto.response.cases.CaseListResponseDto;
import com.mcm.api.entity.Cases;
import com.mcm.api.repository.CaseRepository;



@RestController
public class CaseController {
	
	@Autowired
	CaseRepository caseRepository;
	
	@GetMapping("/caseList")
	public ResponseEntity<String> getCases() throws JSONException {
		Iterable<Cases> cases = caseRepository.findAll();
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
		
		return new ResponseEntity(responseObj.toString(), HttpStatus.OK) ;
	}

}
