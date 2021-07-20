package com.umss.dev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
//@Data
@Entity(name = "Privilege" )
@Table(name = "PRIVILEGE")
public class Privilege {
 
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idPrivilege;
	@Column
	private String privilege;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idRole")
	@JsonBackReference
	private Role roles;
	@Column
	private int identifier;
	
	/*public Privilege() {

	}
	
	public Privilege(String privilege) {
		super();
		this.privilege = privilege;
	}

	public Privilege(int idPrivilege, String privilege, Role roles, int identifier) {
		super();
		this.idPrivilege = idPrivilege;
		this.privilege = privilege;
		this.roles = roles;
		this.identifier = identifier;
	}*/

	public int getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(int idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}	

}
