package com.mcm.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEAM_USER_MAPPING database table.
 * 
 */
@Entity
@IdClass(TeamUserId.class)
@Table(name="TEAM_USER_MAPPING")
@NamedQuery(name="TeamUserMapping.findAll", query="SELECT t FROM TeamUserMapping t")
public class TeamUserMapping implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String isleader;

	private String status;

	//bi-directional many-to-one association to Team
	@Id
	@ManyToOne
	@JoinColumn(name="TID", referencedColumnName="TEAMID")
	private Team team;

	//bi-directional many-to-one association to User
	@Id
	@ManyToOne
	@JoinColumn(name="USERID", referencedColumnName="USERID")
	private User user;

	public TeamUserMapping() {
	}

	public TeamUserMapping(Team team, User u, String isAdmin) {
		this.team = team;
		this.user = u;
		if(u.getId().equals(isAdmin)) {
			this.isleader = isAdmin;
		}
	}

	public String getIsleader() {
		return this.isleader;
	}

	public void setIsleader(String isleader) {
		this.isleader = isleader;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}