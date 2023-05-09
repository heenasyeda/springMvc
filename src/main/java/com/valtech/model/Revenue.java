package com.valtech.model;

public class Revenue {
	
	private int RevenueID;
	private int BranchID;
	private int RevenueAmount;
	private String TimePeriod;
	
	public Revenue() {
		super();
	}

	public Revenue(int revenueID, int branchID, int revenueAmount, String timePeriod) {
		super();
		RevenueID = revenueID;
		BranchID = branchID;
		RevenueAmount = revenueAmount;
		TimePeriod = timePeriod;
	}

	public int getRevenueID() {
		return RevenueID;
	}

	public void setRevenueID(int revenueID) {
		RevenueID = revenueID;
	}

	public int getBranchID() {
		return BranchID;
	}

	public void setBranchID(int branchID) {
		BranchID = branchID;
	}

	public int getRevenueAmount() {
		return RevenueAmount;
	}

	public void setRevenueAmount(int revenueAmount) {
		RevenueAmount = revenueAmount;
	}

	public String getTimePeriod() {
		return TimePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		TimePeriod = timePeriod;
	}

	@Override
	public String toString() {
		return "Revenue [RevenueID=" + RevenueID + ", BranchID=" + BranchID + ", RevenueAmount=" + RevenueAmount
				+ ", TimePeriod=" + TimePeriod + "]";
	}
	
	
	
}
