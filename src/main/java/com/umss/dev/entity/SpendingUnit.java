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
	private String name;	
	@OneToMany(mappedBy = "spendingUnit",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<UserRole> userRole;

	public SpendingUnit() {
		
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

	public SpendingUnit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
