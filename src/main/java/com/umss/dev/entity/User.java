package com.umss.dev.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "User")
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idUser;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private LocalDate registrationDate;
	@Column(columnDefinition = "boolean default false")
	private boolean selected;
	@OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	//@JsonManagedReference
	private List<UserRole> userRole;
	
	public String getName() {
		
		return name;
	}

	public int getIdUser() {
		
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRole() {
		
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		
		return "User [idUser=" + idUser + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userRole=" + userRole + "]";
	}
		
}
