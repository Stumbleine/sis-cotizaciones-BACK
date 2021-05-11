package com.umss.dev.output;

import java.util.List;

import javax.persistence.Column;

import com.umss.dev.entity.PriceQuotation;

public class BusinessOutput {

	private int idBusiness;
	private String name;
	private String description;
	private String adress;
	private String phone;
	private String eMail;
	private String nit;
	//private List<PriceQuotation> priceQuotations ;
	
	public BusinessOutput () {}
	
	public int getIdBusiness() {
		return idBusiness;
	}
	public void setIdBusiness(int idBusiness) {
		this.idBusiness = idBusiness;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
	
	
}
