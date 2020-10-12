package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamUserId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="TID")
	private String team;
	
	@Column(name="USERID")
	private String user;

	public TeamUserId(String team, String user) {
		super();
		this.team = team;
		this.user = user;
	}
	
	public TeamUserId() {
		
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((team == null) ? 0 : team.hashCode());
		result = prime * result
				+ ((user == null) ? 0 : user.hashCode());
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
		
		TeamUserId other = (TeamUserId) obj;
		
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		
		return true;
	}
	
}
