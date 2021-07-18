package com.umss.dev.output;

import java.util.List;

public class SpendingUnitOutput {
	
	private int idSpendingUnit;
	private String nameUnit;
	private String description;
	private String responsable;
	private List<UserOutputAtributes> employees;
	private String faculty;
	
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
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public List<UserOutputAtributes> getEmployees() {
		return employees;
	}
	public void setEmployees(List<UserOutputAtributes> employees) {
		this.employees = employees;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	

}
