package com.mcm.api.controller;

import java.util.List;
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

import com.mcm.api.dto.request.CreateNewUserRequestDto;
import com.mcm.api.dto.request.UserByDepartmentRequestDto;
import com.mcm.api.dto.response.ErrorResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.dto.response.UserByDepartmentResponseDto;
import com.mcm.api.dto.response.UserListResponseDto;
import com.mcm.api.entity.Department;
import com.mcm.api.entity.User;
import com.mcm.api.repository.DepartmentRepository;
import com.mcm.api.repository.UserRepository;



@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/userList")
	public ResponseEntity getUsers() {
		Iterable<User> users = userRepository.findAll();
		List<UserListResponseDto> result = 
				  StreamSupport.stream(users.spliterator(), false).filter(user->user.getLogintype()!="superadmin").map(UserListResponseDto::new)
				    .collect(Collectors.toList());
		return new ResponseEntity(result, HttpStatus.OK) ;
	}
	
	@PostMapping("/userBydepartment")
	public ResponseEntity getUsersByDepartment(@RequestBody UserByDepartmentRequestDto userByDepartmentRequestDto) {
		String loginType = "user";
		Department department = null;
		Optional<Department> optionalDepartment = departmentRepository.findById(userByDepartmentRequestDto.getDepartmentid());
		if(optionalDepartment.isPresent()) {
			department=optionalDepartment.get();
		}else {
			return new ResponseEntity("", HttpStatus.OK);
		}
		Iterable<User> users = userRepository.findByDepartmentAndLogintype(department, loginType);
		List<UserByDepartmentResponseDto> result = 
				  StreamSupport.stream(users.spliterator(), false).map(UserByDepartmentResponseDto::new)
				    .collect(Collectors.toList());
		return new ResponseEntity(result, HttpStatus.OK) ;
	}

	@PostMapping("/userInsert")
	public ResponseEntity createUser(@RequestBody CreateNewUserRequestDto createNewUserRequestDto) {
		User u = userRepository.findByUserid(createNewUserRequestDto.getUserid());
		if(u != null) {
			return new ResponseEntity(new ErrorResponseDto("User ID already present"), HttpStatus.OK) ;
		}
		String loginType = "user";
		Department department = null;
		Optional<Department> optionalDepartment = departmentRepository.findById(createNewUserRequestDto.getDepartment());
		if(optionalDepartment.isPresent()) {
			department=optionalDepartment.get();
		}else {
			department= null;
		}
		
		User user = new User(createNewUserRequestDto, department);
		userRepository.save(user);
		return new ResponseEntity(new SuccessResponseDto("success"), HttpStatus.OK) ;
	}
}
