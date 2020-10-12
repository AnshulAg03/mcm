package com.mcm.api.dto.response;

import com.mcm.api.entity.TeamUserMapping;

public class TeamListResponseDto {
	
	private String TEAMID;
	private String NAME;
	private String DESCRIPTION;
	private String UNAME;
	private String USERID;
	private String ID;
	private String ISLEADER;
	private String DID;
	public TeamListResponseDto() {
		
	}
	public TeamListResponseDto(TeamUserMapping tum) {
		TEAMID = tum.getTeam().getTeamId();
		NAME = tum.getTeam().getName();
		DESCRIPTION = tum.getTeam().getDescription();
		UNAME = tum.getUser().getUname();
		USERID = tum.getUser().getUserid();
		ID = tum.getUser().getId();
		ISLEADER = tum.getIsleader();
		DID = tum.getUser().getDepartment().getId();
	}
	public String getTEAMID() {
		return TEAMID;
	}
	public void setTEAMID(String tEAMID) {
		TEAMID = tEAMID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getUNAME() {
		return UNAME;
	}
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getISLEADER() {
		return ISLEADER;
	}
	public void setISLEADER(String iSLEADER) {
		ISLEADER = iSLEADER;
	}
	public String getDID() {
		return DID;
	}
	public void setDID(String dID) {
		DID = dID;
	}
	
}
