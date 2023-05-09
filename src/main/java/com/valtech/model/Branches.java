package com.valtech.model;

public class Branches {

	private int branchID;
	private String name;
	private String address;
	private String contact;
	public Branches() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branches(int branchID, String name, String address, String contact) {
		super();
		this.branchID = branchID;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Branches [branchID=" + branchID + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ "]";
	}
	
	

	

	
}
