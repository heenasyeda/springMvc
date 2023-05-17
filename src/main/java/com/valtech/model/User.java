package com.valtech.model;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String role;
	
	public User(int userId, String username, String password, String email, String role) {
		super();
		this.userId = userId;
		this.userName = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + userName + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}
	
	
	
	

	

}
