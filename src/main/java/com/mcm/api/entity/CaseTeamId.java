package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CaseTeamId implements Serializable{

	private Team team;
	
	private Cases case_;

	public CaseTeamId(Team team, Cases case_) {
		super();
		this.team = team;
		this.case_ = case_;
	}
	
	public CaseTeamId() {
		
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Cases getCase_() {
		return case_;
	}

	public void setCase_(Cases case_) {
		this.case_ = case_;
	}	
	
}
