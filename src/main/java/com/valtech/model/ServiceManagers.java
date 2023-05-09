package com.valtech.model;

public class ServiceManagers {
	
	private int ServiceManagerID;
	private String Name;
	private String Email;
	private String Contact;
	private int BranchID;
	
	public ServiceManagers(int serviceManagerID, String name, String email, String contact, int branchID) {
		super();
		this.ServiceManagerID = serviceManagerID;
		this.Name = name;
		this.Email = email;
		this.Contact = contact;
		this.BranchID = branchID;
	}

	public ServiceManagers() {
		super();
	}

	public int getServiceManagerID() {
		return ServiceManagerID;
	}

	public void setServiceManagerID(int serviceManagerID) {
		ServiceManagerID = serviceManagerID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String string) {
		Name = string;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public int getBranchID() {
		return BranchID;
	}

	public void setBranchID(int branchID) {
		BranchID = branchID;
	}

	@Override
	public String toString() {
		return "ServiceManagers [ServiceManagerID=" + ServiceManagerID + ", Name=" + Name + ", Email=" + Email
				+ ", Contact=" + Contact + ", BranchID=" + BranchID + "]";
	}
	
	
	
	
	

}
