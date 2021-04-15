package com.umss.dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "SPENDING_UNIT_REQUEST")
public class SpendingUnitRequest {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "idSpendingUnitRequest")
	private int idSpendingUnitRequest;
	
	@Column
	private String name;
	@Column
	private String detail;
	@Column
	private String status;
	@Column
	private String type;
	@Column
	private double estimatedAmount;
	
	@OneToMany(mappedBy = "request",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<RequestDetail> requestDetail=new ArrayList<RequestDetail>();
	
	public SpendingUnitRequest(String name, String detail, String status,String type, double estimatedAmount) {
		super();
		this.name = name;
		this.status=status;
		this.detail=detail;
		this.type=type;
		this.estimatedAmount=estimatedAmount;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<RequestDetail> getRequestDetail() {
		return requestDetail;
	}

	public void setRequestDetail(List<RequestDetail> requestDetail) {
		this.requestDetail = requestDetail;
	}

	public int getIdSpendingUnitRequest() {
		return idSpendingUnitRequest;
	}

	public void setIdSpendingUnitRequest(int idSpendingUnitRequest) {
		this.idSpendingUnitRequest = idSpendingUnitRequest;
	}



}
