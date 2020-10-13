package com.mcm.api.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class SaveAttachmentRequestDto {

	private String caseid;
	private String teamid;
	private MultipartFile fileToUpload;
	
	public SaveAttachmentRequestDto() {
		super();
	}
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
	public MultipartFile getFileToUpload() {
		return fileToUpload;
	}
	public void setFileToUpload(MultipartFile fileToUpload) {
		this.fileToUpload = fileToUpload;
	}
	
}
