package com.mcm.api.dto.response;

import com.mcm.api.entity.TeamUserMapping;

public class GetAllLeadersResponseDto {
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public GetAllLeadersResponseDto(TeamUserMapping tum) {
		super();
		this.userid = tum.getUser().getId();
	}
	
	
}
