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
	private String name;
	@Column
	private Float subTotal;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idComparativeTableOfQuotes")
	@JsonBackReference
	private ComparativeTableOfQuotes comparativeTableOfQuotes;

	/*public int getIdQuotationBusiness() {
		return idQuotationBusiness;
	}

	public void setIdQuotationBusiness(int idQuotationBusiness) {
		this.idQuotationBusiness = idQuotationBusiness;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getSubtotal() {
		return subTotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subTotal = subtotal;
	}

	public ComparativeTableOfQuotes getComparativeTableOfQuotes() {
		return comparativeTableOfQuotes;
	}

	public void setComparativeTableOfQuotes(ComparativeTableOfQuotes comparativeTableOfQuotes) {
		this.comparativeTableOfQuotes = comparativeTableOfQuotes;
	}

}
