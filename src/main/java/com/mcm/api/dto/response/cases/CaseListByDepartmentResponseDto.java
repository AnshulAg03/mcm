package com.mcm.api.dto.response.cases;

public class CaseListByDepartmentResponseDto {
	
	public CaseListByDepartmentResponseDto() {};

	private String id;
	private String departmentid;
	private String status;
	private String department;
	
	
	public CaseListByDepartmentResponseDto(Object case_) {
		super();
		
		Object caseInfo[] =  (Object[]) case_;
		this.id = (String) caseInfo[0];
		this.department = (String) caseInfo[1];
		this.departmentid = (String) caseInfo[2];
		this.status = (String) caseInfo[3];
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

}
