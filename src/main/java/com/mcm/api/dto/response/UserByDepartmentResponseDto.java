package com.mcm.api.dto.response;

import com.mcm.api.entity.User;

public class UserByDepartmentResponseDto {
	
	private String id;
	private String uname;

	private String userid;
	
	public UserByDepartmentResponseDto() {};

	public UserByDepartmentResponseDto(User user) {
		super();
		this.id = user.getId();
		this.uname = user.getUname();
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	

}
