package com.mcm.api.dto.response;

import com.mcm.api.entity.Attachment;

public class GetAttachmentsResponseDto {

	private String ID;
	private String CASEID;
	private String FILEN;
	private String TIMESTAMP;
	private String DBFILENAME;
	private String TEAMID;
	private String USERID;
	
	public GetAttachmentsResponseDto(Attachment attachment) {
		super();
		this.ID = attachment.getId();
		this.CASEID = attachment.getCaseid();
		this.FILEN = attachment.getFilen();
		this.TIMESTAMP = attachment.getTimestmp();
		this.DBFILENAME = attachment.getDbfilename();
		this.TEAMID = attachment.getTeamid();
		this.USERID = attachment.getUserid();
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCASEID() {
		return CASEID;
	}
	public void setCASEID(String cASEID) {
		CASEID = cASEID;
	}
	public String getFILEN() {
		return FILEN;
	}
	public void setFILEN(String fILEN) {
		FILEN = fILEN;
	}
	public String getTIMESTAMP() {
		return TIMESTAMP;
	}
	public void setTIMESTAMP(String tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}
	public String getDBFILENAME() {
		return DBFILENAME;
	}
	public void setDBFILENAME(String dBFILENAME) {
		DBFILENAME = dBFILENAME;
	}
	public String getTEAMID() {
		return TEAMID;
	}
	public void setTEAMID(String tEAMID) {
		TEAMID = tEAMID;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
    
}
