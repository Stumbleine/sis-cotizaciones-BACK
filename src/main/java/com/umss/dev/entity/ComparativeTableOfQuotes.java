package com.umss.dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Data
@Entity(name = "ComparativeTableOfQuotes")
@Table(name = "COMPARATIVE_TABLE_OF_QUOTES")
public class ComparativeTableOfQuotes {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idComparativeTableOfQuotes;
	@Column
	private int quantity;
	@Column
	private String unit;
	@Column
	private String description;
	@Column
	private Double total;
	@Column
	private Float subtotalBussiness1;
	@Column
	private Float subtotalBussiness2;
	@Column
	private Float subtotalBussiness3;
	
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
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Float getSubtotalBussiness1() {
		return subtotalBussiness1;
	}
	public void setSubtotalBussiness1(Float subtotalBussiness1) {
		this.subtotalBussiness1 = subtotalBussiness1;
	}
	public Float getSubtotalBussiness2() {
		return subtotalBussiness2;
	}
	public void setSubtotalBussiness2(Float subtotalBussiness2) {
		this.subtotalBussiness2 = subtotalBussiness2;
	}
	public Float getSubtotalBussiness3() {
		return subtotalBussiness3;
	}
	public void setSubtotalBussiness3(Float subtotalBussiness3) {
		this.subtotalBussiness3 = subtotalBussiness3;
	}

	
	

}
