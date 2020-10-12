package com.mcm.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEP_TEAM_MAPPING database table.
 * 
 */
@Entity
@Table(name="DEP_TEAM_MAPPING")
@NamedQuery(name="DepTeamMapping.findAll", query="SELECT d FROM DepTeamMapping d")
public class DepTeamMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DID", referencedColumnName="ID")
	private Department department;

	//bi-directional one-to-one association to Team
	@OneToOne(mappedBy="depTeamMapping")
	private Team team;

	public DepTeamMapping() {
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}