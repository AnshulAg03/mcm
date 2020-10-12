package com.mcm.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the CASES database table.
 * 
 */
@Entity
//@Embeddable
@Table(name="CASES")
//@NamedQuery(name="Case.findAll", query="SELECT c FROM Case c")
public class Cases implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private String casetype;

	private String cname;

	private BigDecimal datecreation;

	private BigDecimal dateupdate;

	private String departmentid;

	private String description;

	private BigDecimal duedate;

	private String pid;

	private String status;
	
	@OneToMany(mappedBy="case_")
	private List<CaseTeamMapping> caseTeamMappings;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="DEPARTMENTID", referencedColumnName="ID", insertable = false, updatable = false)
    private Department department;

	public Cases() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCasetype() {
		return this.casetype;
	}

	public void setCasetype(String casetype) {
		this.casetype = casetype;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public BigDecimal getDatecreation() {
		return this.datecreation;
	}

	public void setDatecreation(BigDecimal datecreation) {
		this.datecreation = datecreation;
	}

	public BigDecimal getDateupdate() {
		return this.dateupdate;
	}

	public void setDateupdate(BigDecimal dateupdate) {
		this.dateupdate = dateupdate;
	}

	public String getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDuedate() {
		return this.duedate;
	}

	public void setDuedate(BigDecimal duedate) {
		this.duedate = duedate;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<CaseTeamMapping> getCaseTeamMappings() {
		return caseTeamMappings;
	}

	public void setCaseTeamMappings(List<CaseTeamMapping> caseTeamMappings) {
		this.caseTeamMappings = caseTeamMappings;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}