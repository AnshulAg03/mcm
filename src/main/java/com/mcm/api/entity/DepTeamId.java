package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DepTeamId implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="DID")
	private String department;
	
	@Column(name="TID")
	private String team;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public DepTeamId(String department, String team) {
		super();
		this.department = department;
		this.team = team;
	}

	public DepTeamId() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((team == null) ? 0 : team.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		DepTeamId other = (DepTeamId) obj;
		
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		
		return true;
	}
	
	
}
