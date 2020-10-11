package com.mcm.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
//@Embeddable
@Table(name="USERS")
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	@Id
	private String id;

	private String logintype;

	private String password;

	private String status;

	private String uname;

	@Column(unique = true)
	private String userid;
	
	
	//bi-directional many-to-many association to Team
	@ManyToMany(mappedBy="users")
	private List<Team> teams;
	
	//bi-directional many-to-one association to Department
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="DEPARTMENTID", referencedColumnName="ID")
		private Department department;


	public User() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogintype() {
		return this.logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}