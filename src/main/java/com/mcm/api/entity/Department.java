package com.mcm.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the DEPARTMENT database table.
 * 
 */
@Entity
//@Embeddable
//@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	private String department;

	//bi-directional many-to-one association to DepTeamMapping
	@OneToMany(mappedBy="department")
	private List<DepTeamMapping> depTeamMappings;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="department")
	private List<User> users;
	
	@OneToMany(mappedBy="department")
	private List<User> cases;

	public Department() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<DepTeamMapping> getDepTeamMappings() {
		return this.depTeamMappings;
	}

	public void setDepTeamMappings(List<DepTeamMapping> depTeamMappings) {
		this.depTeamMappings = depTeamMappings;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}