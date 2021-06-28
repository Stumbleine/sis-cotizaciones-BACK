package com.umss.dev.output;

import java.util.List;

public class SpendingUnitOutput {
	
	private int idSpendingUnit;
	private String nameUnit;
	private String description;
	private List<String> responsable;
	
	public int getIdSpendingUnit() {
		return idSpendingUnit;
	}
	public void setIdSpendingUnit(int idSpendingUnit) {
		this.idSpendingUnit = idSpendingUnit;
	}
	public String getNameUnit() {
		return nameUnit;
	}
	public void setNameUnit(String nameUnit) {
		this.nameUnit = nameUnit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getResponsable() {
		return responsable;
	}
	public void setResponsable(List<String> responsable) {
		this.responsable = responsable;
	}
 
	
}
