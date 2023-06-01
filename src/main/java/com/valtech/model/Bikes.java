package com.valtech.model;

public class Bikes {
	private int bikeID;
	private String ownerName;
	private String ownerContact;
	private String model;
	private String serviceDetails;
	private int serviceManagerID;
	private String status;
	
	public Bikes() {
		super();
	}
	
	public Bikes(int bikeID, String ownerName, String ownerContact, String model, String serviceDetails,
			int serviceManagerID, String status) {
		
		this.bikeID = bikeID;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
		this.model = model;
		this.serviceDetails = serviceDetails;
		this.serviceManagerID = serviceManagerID;
		this.status = status;
	}
	public int getBikeID() {
		return bikeID;
	}
	public void setBikeID(int bikeID) {
		this.bikeID = bikeID;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerContact() {
		return ownerContact;
	}
	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}
	public int getServiceManagerID() {
		return serviceManagerID;
	}
	public void setServiceManagerID(int serviceManagerID) {
		this.serviceManagerID = serviceManagerID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	




	
	
	
}
