package com.mcm.api.dto.response;

import javax.persistence.Column;
import javax.persistence.Id;

import com.mcm.api.entity.User;

public class UserListResponseDto {
	
	public UserListResponseDto() {};

	private String id;
	private String uname;
	private String departmentId;
	private String email;

	private String password;

	private String logintype;
	private String status;
	
	private String userid;
	private String department;

	public UserListResponseDto(User user) {
		super();
		this.id = user.getId();
		this.uname = user.getUname();
		this.department = user.getDepartment()!=null ? user.getDepartment().getDepartment():"";
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.logintype = user.getLogintype();
		this.status = user.getStatus();
		this.userid = user.getUserid();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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

	public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	

	

	
	
	

}
