package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DepTeamId implements Serializable{
	private static final long serialVersionUID = 1L;

	private Department department;
	
	private Team team;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public DepTeamId(Department department, Team team) {
		super();
		this.department = department;
		this.team = team;
	}

	public DepTeamId() {
		super();
	}
	
	
}
