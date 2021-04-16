package com.umss.dev.entity;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SPENDING_UNIT_REQUEST")
public class SpendingUnitRequest {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idSpendingUnitRequest;
	
	@Column
	private String name;
	@Column
	private Date date;
	@Column
	private String status;
	@Column
	private String type;
	@Column
	private double estimatedAmount;
	@Column
	private String justification;
	
	@OneToMany(mappedBy = "request",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<RequestDetail> requestDetail;

	public int getIdSpendingUnitRequest() {
		return idSpendingUnitRequest;
	}

	public void setIdSpendingUnitRequest(int idSpendingUnitRequest) {
		this.idSpendingUnitRequest = idSpendingUnitRequest;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
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

	public List<RequestDetail> getRequestDetail() {
		return requestDetail;
	}

	public void setRequestDetail(List<RequestDetail> requestDetail) {
		this.requestDetail = requestDetail;
	}

}
