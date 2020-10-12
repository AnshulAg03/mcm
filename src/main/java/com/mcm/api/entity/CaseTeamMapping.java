package com.mcm.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEAM_USER_MAPPING database table.
 * 
 */
@Entity
@Table(name="CASE_TEAM_MAPPING")
@NamedQuery(name="CaseTeamMapping.findAll", query="SELECT t FROM CaseTeamMapping t")
public class CaseTeamMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;

	@EmbeddedId
	private CaseTeamId id;
	
	@ManyToOne
	@JoinColumn(name="TID", insertable = false, updatable = false)
	private Team team;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="CID", insertable = false, updatable = false)
	private Cases case_;

	public CaseTeamMapping() {
	}

	public CaseTeamMapping(Team team, Cases case_, String status) {
		this.id = new CaseTeamId(team.getTeamId(), case_.getId());
		this.team = team;
		this.case_ = case_;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
