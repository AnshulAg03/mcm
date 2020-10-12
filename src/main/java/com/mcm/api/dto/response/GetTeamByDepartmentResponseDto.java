package com.mcm.api.dto.response;

import com.mcm.api.entity.Team;

public class GetTeamByDepartmentResponseDto {

	private String teamId;
	
	private String name;

	public GetTeamByDepartmentResponseDto() {
		super();
	}
	

	public GetTeamByDepartmentResponseDto(Team team) {
		super();
		this.teamId = team.getTeamId();
		this.name = team.getName();
	}


	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
