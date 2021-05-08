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
@Entity(name = "Area")
@Table(name = "AREA")
public class Area {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idArea;
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToMany(mappedBy = "area",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<BusinessArea> businessAreas;
	
	public int getIdArea() {
		return idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
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
	public List<BusinessArea> getBusinessAreas() {
		return businessAreas;
	}
	public void setBusinessAreas(List<BusinessArea> businessAreas) {
		this.businessAreas = businessAreas;
	}
	
	

}
