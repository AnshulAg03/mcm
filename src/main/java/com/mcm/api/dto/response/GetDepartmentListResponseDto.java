package com.mcm.api.dto.response;

import com.mcm.api.entity.Department;

public class GetDepartmentListResponseDto {

	private String id;

	private String department;

	public GetDepartmentListResponseDto(Department d) {
		super();
		this.id=d.getId();
		this.department = d.getDepartment();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
