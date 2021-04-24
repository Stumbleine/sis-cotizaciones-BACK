package com.umss.dev.output;

import java.time.LocalDate;
import java.util.List;

import com.umss.dev.entity.RequestDetail;

public class SpendingUnitRequesteOutputAtributes {

	private int idSpendingUnitRequest;
	private String initials;//
	private LocalDate date;
	private String status;
	private String type;
	private double estimatedAmount;
	private String justification;
	private String username;
	private List<RequestDetail> requestDetail;
	
	public SpendingUnitRequesteOutputAtributes(){
		
	}
	
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
	
	public String getUsername() {
	
		return username;
	}
	
	public void setUsername(String username) {
	
		this.username = username;
	}
	
	public List<RequestDetail> getRequestDetail() {
	
		return requestDetail;
	}
	
	public void setRequestDetail(List<RequestDetail> requestDetail) {
	
		this.requestDetail = requestDetail;
	}
	
}
