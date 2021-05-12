package com.umss.dev.entity;

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

import lombok.Data;

@Data
@Entity(name = "ComparativeTableOfQuotes")
@Table(name = "COMPARATIVE_TABLE_OF_QUOTES")
public class ComparativeTableOfQuotes {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idComparativeTableOfQuotes;
	@Column
	private int idPriceQuotationDetail;
	@Column
	private int quantity;
	@Column
	private String unit;
	@Column
	private String description;
	
	@OneToMany(mappedBy = "comparativeTableOfQuotes",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})	
	@JsonManagedReference
	private List<QuotationBusiness> quotationBusiness;
	
	
	public int getIdComparativeTableOfQuotes() {
		return idComparativeTableOfQuotes;
	}
	public void setIdComparativeTableOfQuotes(int idComparativeTableOfQuotes) {
		this.idComparativeTableOfQuotes = idComparativeTableOfQuotes;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<QuotationBusiness> getQuotationBusiness() {
		return quotationBusiness;
	}
	public void setQuotationBusiness(List<QuotationBusiness> quotationBusiness) {
		this.quotationBusiness = quotationBusiness;
	}

}
