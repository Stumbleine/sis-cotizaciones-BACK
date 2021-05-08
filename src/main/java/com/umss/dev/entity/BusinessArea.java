package com.umss.dev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "BusinessArea")
@Table(name = "BUSINESS_AREA")
public class BusinessArea {
	
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idBusinessArea;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idBusiness")
	private Business business;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idArea")
	private Area area;

	public int getIdBusinessArea() {
		return idBusinessArea;
	}

	public void setIdBusinessArea(int idBusinessArea) {
		this.idBusinessArea = idBusinessArea;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	

}
