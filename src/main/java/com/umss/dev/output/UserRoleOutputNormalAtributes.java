package com.umss.dev.output;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.umss.dev.entity.Administration;
import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.entity.UserSis;

public class UserRoleOutputNormalAtributes {

private int idUserRole;
	
	private UserSis user;
	private Role role;
	private SpendingUnit spendingUnit;
	//private Administration administration;
	private List<SpendingUnitRequest> spendingUnitRequest;
		
	public int getIdUserRole() {
		
		return idUserRole;
	}
	
	public void setIdUserRole(int idUserRole) {
		this.idUserRole = idUserRole;
	}
	
	public UserSis getUser() {
		
		return user;
	}
	
	public void setUser(UserSis user) {
		this.user = user;
	}
	
	public Role getRole() {
		
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public SpendingUnit getSpendingUnit() {
		
		return spendingUnit;
	}
	
	public void setSpendingUnit(SpendingUnit spendingUnit) {
		this.spendingUnit = spendingUnit;
	}
	
	/*public Administration getAdministration() {
		
		return administration;
	}
	
	public void setAdministration(Administration administration) {
		this.administration = administration;
	}*/
	
	public List<SpendingUnitRequest> getSpendingUnitRequest() {
		
		return spendingUnitRequest;
	}
	
	public void setSpendingUnitRequest(List<SpendingUnitRequest> spendingUnitRequest) {
		this.spendingUnitRequest = spendingUnitRequest;
	}
	
}
