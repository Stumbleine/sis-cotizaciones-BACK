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
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idReport;
	
	@Column(length = 1000)
	private String commentary;
	
	@JoinColumn(name = "idPriceQuotationRequest" ,nullable = true)
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
	private PriceQuotationRequest priceQuotation;

	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "idFile",unique = true)
	private DocumentQuotation documentQuotation;
	
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

}