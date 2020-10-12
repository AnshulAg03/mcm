package com.mcm.api.dto.response.cases;

import java.math.BigDecimal;

import com.mcm.api.entity.Cases;

public class CaseListResponseDto {
	
	public CaseListResponseDto() {};

	private String id;
	private String cname;
	private String casetype;
	private BigDecimal duedate;

	private String status;

	private String name;
	private String department;
	
	private String departmentid;
	
	
	public CaseListResponseDto(Cases case_) {
		super();
		this.id = case_.getId();
		this.cname = case_.getCname();
		this.casetype = case_.getCasetype();
		this.duedate = case_.getDuedate();
		this.status = case_.getStatus();
		this.name = case_.getCaseTeamMappings().get(0).getTeam().getName();
		this.department = case_.getDepartment().getDepartment();
		this.departmentid = case_.getDepartmentid();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCasetype() {
		return casetype;
	}


	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}


	public BigDecimal getDuedate() {
		return duedate;
	}


	public void setDuedate(BigDecimal duedate) {
		this.duedate = duedate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	
}
