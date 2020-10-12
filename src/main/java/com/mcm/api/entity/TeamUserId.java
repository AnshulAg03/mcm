package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TeamUserId implements Serializable{

	private Team team;
	
	private User user;

	public TeamUserId(Team team, User user) {
		super();
		this.team = team;
		this.user = user;
	}
	
	public TeamUserId() {
		
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
