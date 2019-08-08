package com.sliit.af.model;

public class JWTUser {

	private String username;
	private long Id;
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "JWTUser [username=" + username + ", Id=" + Id + ", role=" + role + "]";
	}
	
	

}
