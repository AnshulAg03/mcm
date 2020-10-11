package com.mcm.api.dto.request;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreateNewUserRequestDto {
	
	public String department;
	private String logintype;
	private String name;

	private String email;

	private String password;

	private String status;

	private String userid;

	public CreateNewUserRequestDto() {
		
	}

	public CreateNewUserRequestDto(String department, String logintype, String name, String email, String password,
			String status, String userid) {
		super();
		this.department = department;
		this.logintype = logintype;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.userid = userid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
