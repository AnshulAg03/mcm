package com.mcm.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the ATTACHMENT database table.
 * 
 */
@Entity
//@Embeddable
//@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private String caseid;

	private String dbfilename;

	private String filen;

	

	private String teamid;

	private String timestmp;

	private String userid;

	public Attachment() {
	}

	public String getCaseid() {
		return this.caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	public String getDbfilename() {
		return this.dbfilename;
	}

	public void setDbfilename(String dbfilename) {
		this.dbfilename = dbfilename;
	}

	public String getFilen() {
		return this.filen;
	}

	public void setFilen(String filen) {
		this.filen = filen;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamid() {
		return this.teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public String getTimestmp() {
		return this.timestmp;
	}

	public void setTimestmp(String timestmp) {
		this.timestmp = timestmp;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}