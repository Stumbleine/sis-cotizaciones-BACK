package com.umss.dev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//@Data
@Entity(name = "QuotationBusiness")
@Table(name = "QUOTATION_BUSINESS")
public class QuotationBusiness {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuotationBusiness;
	@Column
	private String nameBusiness;
	@Column
	private Float subtotal;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idComparativeTableOfQuotes")
	@JsonBackReference
	private ComparativeTableOfQuotes comparativeTableOfQuotes;

	public String getNameBusiness() {
		return nameBusiness;
	}

	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public ComparativeTableOfQuotes getComparativeTableOfQuotes() {
		return comparativeTableOfQuotes;
	}

	public void setComparativeTableOfQuotes(ComparativeTableOfQuotes comparativeTableOfQuotes) {
		this.comparativeTableOfQuotes = comparativeTableOfQuotes;
	}

}
