package com.mcm.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcm.api.dto.response.UserListResponseDto;
import com.mcm.api.entity.User;
import com.mcm.api.repository.UserRepository;



@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/userList")
	public ResponseEntity getUsers() {
		Iterable<User> users = userRepository.findAll();
//		Iterator<User> usersItr = users.iterator();
//		while (usersItr.hasNext()) {
//			customers.add(new CustomerResponseDto(usersItr.next()));
//		}
		List<UserListResponseDto> result = 
				  StreamSupport.stream(users.spliterator(), false).map(UserListResponseDto::new)
				    .collect(Collectors.toList());
		return new ResponseEntity(result, HttpStatus.OK) ;
	}

}
