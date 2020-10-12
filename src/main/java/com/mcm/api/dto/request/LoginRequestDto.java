package com.mcm.api.dto.request;

public class LoginRequestDto {

	private String userid;
	
	private String password;

	public LoginRequestDto() {
		super();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
