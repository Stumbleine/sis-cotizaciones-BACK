package com.umss.dev.input;

public class SpendingUnitRequestFilteredWithUserIdInput {
	
	private int userRolId;
	private String spendingUnitRequestStatus;
	
	public SpendingUnitRequestFilteredWithUserIdInput () {}


	public int getUserRolId() {
		return userRolId;
	}



	public void setUserRolId(int userRolId) {
		this.userRolId = userRolId;
	}

	public String getSpendingUnitRequestStatus() {
		return spendingUnitRequestStatus;
	}

	public void setSpendingUnitRequestStatus(String spendingUnitRequestStatus) {
		this.spendingUnitRequestStatus = spendingUnitRequestStatus;
	}
	
	

}
