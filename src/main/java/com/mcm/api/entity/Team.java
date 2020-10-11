package com.mcm.api.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEAMS database table.
 * 
 */
@Entity
//@Embeddable
@Table(name="TEAMS")
//@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String teamId;

	private String description;

	private String name;

	//bi-directional many-to-many association to Cas
	@ManyToMany(mappedBy="teams")
	private List<Cases> cases;

	//bi-directional many-to-many association to Department
	@ManyToMany(mappedBy="teams")
	private List<Department> departments;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="TEAM_USER_MAPPING"
		, joinColumns={
			@JoinColumn(name="TID", referencedColumnName="TEAMID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="USERID", referencedColumnName="ID")
			}
		)
	private List<User> users;

	public Team() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cases> getCases() {
		return this.cases;
	}

	public void setCases(List<Cases> cases) {
		this.cases = cases;
	}

	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}