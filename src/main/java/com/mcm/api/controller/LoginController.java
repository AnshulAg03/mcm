package com.mcm.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcm.api.dto.request.LoginRequestDto;
import com.mcm.api.dto.response.ErrorResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.entity.User;
import com.mcm.api.repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/auth")
	public ResponseEntity login(@RequestBody LoginRequestDto req) {
		User user = userRepo.findByUseridAndPassword(req.getUserid(), req.getPassword());
		if(user==null) {
			return new ResponseEntity<>(new ErrorResponseDto("user details missmetch"), HttpStatus.OK);	
		}
		return new ResponseEntity<>(new SuccessResponseDto("success"), HttpStatus.OK);
		
	}
	
}
