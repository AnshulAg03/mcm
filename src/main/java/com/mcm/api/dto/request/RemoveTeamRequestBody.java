package com.mcm.api.dto.request;

public class RemoveTeamRequestBody {

	private String caseid;
	private String teamid;
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public String getTeamid() {
		return teamid;
	}
	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}
	public RemoveTeamRequestBody() {
		
	}
	
	
}
