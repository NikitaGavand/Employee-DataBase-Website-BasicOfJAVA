package com.cg.empmaintenance.dto;

public class UserMasterBean {

	private int UserId;
	private String username;
	private String password;
	private String type;

	//getters and setters
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "UserMasterBean [UserId=" + UserId + ", username=" + username
				+ ", password=" + password + ", type=" + type + "]";
	}
}
