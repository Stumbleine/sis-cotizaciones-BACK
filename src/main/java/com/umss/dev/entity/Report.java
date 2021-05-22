package com.umss.dev.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "Report" )
@Table(name = "REPORT")
public class Report {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private int idReport;
	
	@Column(length = 1000)
	private String commentary;
	
	@JoinColumn(name = "idPriceQuotationRequest" ,nullable = true)
	@OneToOne(cascade =CascadeType.ALL )
	private PriceQuotationRequest priceQuotation;

	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "idFile",unique = true)
	private DocumentQuotation documentQuotation;
	
	
	
	public Report() {
	
	}

	public Report(String commentary, PriceQuotationRequest priceQuotation) {
		super();
		this.commentary = commentary;
		this.priceQuotation = priceQuotation;
	}

	public int getIdReport() {
		return idReport;
	}

	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public PriceQuotationRequest getPriceQuotation() {
		return priceQuotation;
	}

	public void setPriceQuotation(PriceQuotationRequest priceQuotation) {
		this.priceQuotation = priceQuotation;
	}

	public DocumentQuotation getDocumentQuotation() {
		return documentQuotation;
	}

	public void setDocumentQuotation(DocumentQuotation documentQuotation) {
		this.documentQuotation = documentQuotation;
	}
 
}