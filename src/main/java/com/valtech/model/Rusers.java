package com.valtech.model;

public class Rusers {
	
	private int userID;
	private String name ;
    private String email;
    private String password;
    private String role;
    
	public Rusers() {
		super();
	}
	public Rusers(int userID, String name, String email, String password, String role) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Rusers [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}
    
	
	
	
	
	
	
}
