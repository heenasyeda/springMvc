package com.valtech.viewAndModel;

public class RevenueVm {
	
	private int revenueID;
	private int branchID;
	private int revenueAmount;
	private String timePeriod;
	private int serviceManagerID;
	
	public RevenueVm() {
		super();
	}

	public RevenueVm(int revenueID, int branchID, int revenueAmount, String timePeriod, int serviceManagerID) {
		super();
		this.revenueID = revenueID;
		this.branchID = branchID;
		this.revenueAmount = revenueAmount;
		this.timePeriod = timePeriod;
		this.serviceManagerID = serviceManagerID;
	}

	public int getRevenueID() {
		return revenueID;
	}

	public void setRevenueID(int revenueID) {
		this.revenueID = revenueID;
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public int getRevenueAmount() {
		return revenueAmount;
	}

	public void setRevenueAmount(int revenueAmount) {
		this.revenueAmount = revenueAmount;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public int getServiceManagerID() {
		return serviceManagerID;
	}

	public void setServiceManagerID(int serviceManagerID) {
		this.serviceManagerID = serviceManagerID;
	}

	@Override
	public String toString() {
		return "Revenue [revenueID=" + revenueID + ", branchID=" + branchID + ", revenueAmount=" + revenueAmount
				+ ", timePeriod=" + timePeriod + ", serviceManagerID=" + serviceManagerID + "]";
	}
	
	

	
	
	
	



}
