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

@Entity(name = "ComparateTables")
@Table(name = "COMPARATE_TABLES	")
public class ComparateTable {

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "idComparateTable")
	private int idComparateTable;
	
	@OneToMany(mappedBy = "comparateTable",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<PriceQuotation> priceQuotations;

	public ComparateTable() {
		super();
	}

	public int getIdComparateTable() {
		return idComparateTable;
	}

	public void setIdComparateTable(int idComparateTable) {
		this.idComparateTable = idComparateTable;
	}

	public List<PriceQuotation> getPriceQuotations() {
		return priceQuotations;
	}

	public void setPriceQuotations(List<PriceQuotation> priceQuotations) {
		this.priceQuotations = priceQuotations;
	} 
	
	
}
