package com.example.cdek.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProf {
	@Id
	private String id;
	private String username;
	private String password;
	private boolean active;
	private String roles;
	
	public UserProf() {
	}
	
	public UserProf(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public UserProf(String id, String username, String password, String roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
