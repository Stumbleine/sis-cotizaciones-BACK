package com.umss.dev.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity(name = "Business")
@Table(name = "BUSINESS")
public class Business {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBusiness;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String adress;
	@Column
	private String phone;
	@Column
	private String eMail;
	@Column
	private String nit;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idArea")
	@JsonBackReference
	private Area area;
	
	@OneToMany(mappedBy = "business",cascade = CascadeType.ALL)
	private List<PriceQuotation> priceQuotations;

	public Business(String name, String description, String adress, String phone, String eMail, String nit, Area area) {
		super();
		this.name = name;
		this.description = description;
		this.adress = adress;
		this.phone = phone;
		this.eMail = eMail;
		this.nit = nit;
		this.area = area;
	}

	public Business(String name, String description, String adress, String phone, String eMail, String nit) {
		super();
		this.name = name;
		this.description = description;
		this.adress = adress;
		this.phone = phone;
		this.eMail = eMail;
		this.nit = nit;
	}

	public Business() {
		super();
	}
	
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Business [idBusiness=" + idBusiness + ", name=" + name + ", description=" + description + ", adress="
				+ adress + ", phone=" + phone + ", eMail=" + eMail + ", nit=" + nit + ", area=" + area
				+ ", priceQuotations=" + priceQuotations + "]";
	}
	
}
