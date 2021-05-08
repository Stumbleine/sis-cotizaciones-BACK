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

import lombok.Data;

@Data
@Entity(name = "Business")
@Table(name = "BUSINESS")
public class Business {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idBusiness;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String NIT;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "business",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<BusinessArea> businessArea;
		
	
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
	public String getNIT() {
		return NIT;
	}
	public void setNIT(String nIT) {
		NIT = nIT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdBusiness() {
		return idBusiness;
	}
	public void setIdBusiness(int idBusiness) {
		this.idBusiness = idBusiness;
	}
	public List<BusinessArea> getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(List<BusinessArea> businessArea) {
		this.businessArea = businessArea;
	}

	
}
