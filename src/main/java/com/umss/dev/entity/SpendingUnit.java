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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "Spending_Unit")
@Table(name = "SPENDING_UNIT")
public class SpendingUnit {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "idSpendingUnit")
	private int idSpendingUnit;
	@Column
	private String nameUnit;
	@Column(length = 1000)
	private String description;
	@Column
	private String faculty;
	@OneToMany(mappedBy = "spendingUnit",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	//@JsonManagedReference
	private List<UserRole> userRole;
	@Column
	private String acronym;

	public SpendingUnit() {
		
	}	

	public SpendingUnit(String nameUnit) {
		super();
		this.nameUnit = nameUnit;
	}
	
	public int getIdSpendingUnit() {
	
		return idSpendingUnit;
	}

	public void setIdSpendingUnit(int idSpendingUnit) {
		this.idSpendingUnit = idSpendingUnit;
	}

	public List<UserRole> getUserRole() {
		
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
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

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
		
}
