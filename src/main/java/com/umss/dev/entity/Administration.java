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
@Entity(name = "Administration")
@Table(name = "ADMINISTRATION")
public class Administration {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "idAdministration")
	private int idAdministration;
	@Column
	private String name;
	@OneToMany(mappedBy = "administration",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<UserRole> userRole;
	
	public Administration() {
		
	}
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
