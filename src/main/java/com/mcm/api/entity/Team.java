package com.mcm.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mcm.api.dto.request.CreateNewTeamRequestDto;


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

	//bi-directional many-to-one association to TeamUserMapping
		@OneToMany(mappedBy="team")
		private List<TeamUserMapping> teamUserMappings;


	public Team() {
	}
	
	public Team(CreateNewTeamRequestDto request) {
		super();
		this.name = request.getTeamName();
		this.description = request.getDescription();
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
	
	public List<TeamUserMapping> getTeamUserMappings() {
		return this.teamUserMappings;
	}

	public void setTeamUserMappings(List<TeamUserMapping> teamUserMappings) {
		this.teamUserMappings = teamUserMappings;
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

}