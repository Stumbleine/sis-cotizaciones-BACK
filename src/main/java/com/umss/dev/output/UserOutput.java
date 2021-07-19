package com.umss.dev.output;

import java.time.LocalDate;
import java.util.List;

import com.umss.dev.entity.Privilege;

public class UserOutput {

	private int idUser;
	private String name;
	private String username;
	private String role;
	private String email;
	private LocalDate registrationDate;
	private String spendingUnit;
	private List<Privilege> privileges;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getSpendingUnit() {
		return spendingUnit;
	}
	public void setSpendingUnit(String spendingUnit) {
		this.spendingUnit = spendingUnit;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
