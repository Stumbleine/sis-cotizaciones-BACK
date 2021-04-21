package com.umss.dev.output;

import java.util.List;



public class CompleteUserOutput {
	
	private int idUser;
	private String name;
	private String email;
	private String password;
	private List<CompleteUserRoleOutput> userRole;
	
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
	
	public List<CompleteUserRoleOutput> getUserRole() {
	
		return userRole;
	}
	
	public void setUserRole(List<CompleteUserRoleOutput> userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
	
		return "CompleteUserOutput [idUser=" + idUser + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userRole=" + userRole + "]";
	}
	
}
