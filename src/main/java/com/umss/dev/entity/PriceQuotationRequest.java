package com.umss.dev.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

//@Data
@Entity(name = "PriceQuotationRequest" )
@Table(name = "PRICE_QUOTATON_REQUEST")

public class PriceQuotationRequest {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idPriceQuotationRequest;
	
	@Column
	private LocalDate deadline;
	
	/**/
	@OneToMany(mappedBy = "priceQuotationRequest",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<PriceQuotation> priceQuotations; 
	
	/**/
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idUserRole")
	@JsonBackReference
	private UserRole userRole;
	
	@JoinColumn(name = "idSpendingUnitRequest" )
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
	//@JsonManagedReference
	private SpendingUnitRequest spendingUnitRequest;
	
	@OneToMany(mappedBy = "priceQuotationRequest",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})	
	@JsonManagedReference
	private List<ComparativeTableOfQuotes> ComparativeTableOfQuotes;
	
	@JoinColumn(name = "idReport" )
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
	private Report report;
	
	
	
	
	public PriceQuotationRequest() {

	}

	public PriceQuotationRequest(LocalDate deadline, UserRole userRole, SpendingUnitRequest spendingUnitRequest) {
		super();
		this.deadline = deadline;
		this.userRole = userRole;
		this.spendingUnitRequest = spendingUnitRequest;
	
	}

	public SpendingUnitRequest getSpendingUnitRequest() {
		return spendingUnitRequest;
	}

	public void setSpendingUnitRequest(SpendingUnitRequest spendingUnitRequest) {
		this.spendingUnitRequest = spendingUnitRequest;
	}

	public int getIdPriceQuotationRequest() {
		return idPriceQuotationRequest;
	}

	public void setIdPriceQuotationRequest(int idPriceQuotationRequest) {
		this.idPriceQuotationRequest = idPriceQuotationRequest;
	}


	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<ComparativeTableOfQuotes> getComparativeTableOfQuotes() {
		return ComparativeTableOfQuotes;
	}

	public void setComparativeTableOfQuotes(List<ComparativeTableOfQuotes> comparativeTableOfQuotes) {
		ComparativeTableOfQuotes = comparativeTableOfQuotes;
	}
	
	public LocalDate  getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate  deadline) {
		this.deadline = deadline;
	}

	public List<PriceQuotation> getPriceQuotations() {
		return priceQuotations;
	}

	public void setPriceQuotations(List<PriceQuotation> priceQuotations) {
		this.priceQuotations = priceQuotations;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
}
