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
@Entity(name = "Area" )
@Table(name = "AREA")
public class Area {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idArea;
	@Column
	private String name;
	
	@OneToMany(mappedBy = "area",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})	
	private List<Business> business;

	public Area(String name, List<Business> business) {
		super();
		this.name = name;
		this.business = business;
	}

	public Area(int idArea, String name) {
		super();
		this.idArea = idArea;
		this.name = name;
	}

	public Area() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Business> getBusiness() {
		return business;
	}

	public void setBusiness(List<Business> business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", name=" + name + ", business=" + business + "]";
	}
	
	
	
}
