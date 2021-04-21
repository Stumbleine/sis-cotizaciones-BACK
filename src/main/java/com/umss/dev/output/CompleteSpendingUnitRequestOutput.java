package com.umss.dev.output;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;



public class CompleteSpendingUnitRequestOutput {


	private int idSpendingUnitRequest;
	private String initials;//
	private LocalDate date;
	private String status;
	private String type;
	private double estimatedAmount;
	private String justification;
	//private List<RequestDetail> requestDetail;
	private int userId;
	private String username;
	private int roleId;
	private String roleName;
	
	
	public int getIdSpendingUnitRequest() {
		return idSpendingUnitRequest;
	}
	public void setIdSpendingUnitRequest(int idSpendingUnitRequest) {
		this.idSpendingUnitRequest = idSpendingUnitRequest;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoleId() {
		return roleId; 
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
