package com.mcm.api.dto.response;

import com.mcm.api.entity.Team;

public class isLeaderResponseDto {

	private String TID;

	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public isLeaderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public isLeaderResponseDto(Team team) {
		this.TID = team.getTeamId();
		// TODO Auto-generated constructor stub
	}
	
	
}
