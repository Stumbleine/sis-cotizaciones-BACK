package com.umss.dev.input;

import javax.persistence.Column;

public class CreateBusinessInput {
	
	private String nameBusiness;
	private String description;
	private String address;
	private String phone;
	private String eMail;
	private String nit;
	private String nameArea;
	private int idQuotation;
	
	public String getNameBusiness() {
		return nameBusiness;
	}
	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getNameArea() {
		return nameArea;
	}
	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}
	public int getIdQuotation() {
		return idQuotation;
	}
	public void setIdQuotation(int idQuotation) {
		this.idQuotation = idQuotation;
	}
	
	
}
