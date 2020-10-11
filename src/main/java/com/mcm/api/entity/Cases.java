package com.mcm.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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

	//bi-directional many-to-many association to Team
	@ManyToMany
	@JoinTable(
		name="CASE_TEAM_MAPPING"
		, joinColumns={
			@JoinColumn(name="CID", referencedColumnName="ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="TID", referencedColumnName="TEAMID")
			}
		)
	private List<Team> teams;

	public Cases() {
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

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}