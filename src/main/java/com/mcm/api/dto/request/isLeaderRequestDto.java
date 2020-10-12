package com.mcm.api.dto.request;

public class isLeaderRequestDto {

	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public isLeaderRequestDto(String userid) {
		super();
		this.userid = userid;
	}
	
	public isLeaderRequestDto() {
		
	}
	
}
