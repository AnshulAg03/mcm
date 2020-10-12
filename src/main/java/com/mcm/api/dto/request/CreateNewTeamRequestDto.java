package com.mcm.api.dto.request;

import java.util.List;

public class CreateNewTeamRequestDto {

	public String department;
	private String teamName;
	private String description;

	private List<String> teamMembers;

	private String isAdmin;
	
	public CreateNewTeamRequestDto() {
		
	}

	public CreateNewTeamRequestDto(String department, String teamName, String description, List<String> teamMembers,
			String isAdmin) {
		super();
		this.department = department;
		this.teamName = teamName;
		this.description = description;
		this.teamMembers = teamMembers;
		this.isAdmin = isAdmin;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
}
