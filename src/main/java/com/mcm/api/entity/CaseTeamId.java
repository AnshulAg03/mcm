package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CaseTeamId implements Serializable{

	@Column(name="TID")
	private String team;
	
	@Column(name="CID")
	private String case_;

	public CaseTeamId(String team, String case_) {
		super();
		this.team = team;
		this.case_ = case_;
	}
	
	public CaseTeamId() {
		
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getCase_() {
		return case_;
	}

	public void setCase_(String case_) {
		this.case_ = case_;
	}	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((team == null) ? 0 : team.hashCode());
		result = prime * result
				+ ((case_ == null) ? 0 : case_.hashCode());
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
		
		CaseTeamId other = (CaseTeamId) obj;
		
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		
		if (case_ == null) {
			if (other.case_ != null)
				return false;
		} else if (!case_.equals(other.case_))
			return false;
		
		return true;
	}

	
}
