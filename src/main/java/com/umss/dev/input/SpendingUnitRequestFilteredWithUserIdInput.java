package com.umss.dev.input;

public class SpendingUnitRequestFilteredWithUserIdInput {
	
	private int userId;
	private String spendingUnitRequestStatus;
	
	public SpendingUnitRequestFilteredWithUserIdInput () {}


	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getSpendingUnitRequestStatus() {
		return spendingUnitRequestStatus;
	}

	public void setSpendingUnitRequestStatus(String spendingUnitRequestStatus) {
		this.spendingUnitRequestStatus = spendingUnitRequestStatus;
	}
	
	

}
