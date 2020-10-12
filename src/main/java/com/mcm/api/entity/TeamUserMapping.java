package com.mcm.api.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEAM_USER_MAPPING database table.
 * 
 */
@Entity
@Table(name="TEAM_USER_MAPPING")
public class TeamUserMapping implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TeamUserId id;
	
	private String isleader;

	private String status;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="TID", insertable = false, updatable = false)
	private Team team;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID", insertable = false, updatable = false)
	private User user;

	public TeamUserMapping() {
	}

	public TeamUserMapping(Team team, User u, String isAdmin) {
		this.id= new TeamUserId(team.getTeamId(), user.getId());
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