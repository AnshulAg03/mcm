package com.mcm.api.dto.request;

import java.util.List;

public class UpdateTeamRequestDto {


	private String teamid;
	
	private String caseid;

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public String getCaseid() {
		return caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	public UpdateTeamRequestDto() {
		super();
	}

}
