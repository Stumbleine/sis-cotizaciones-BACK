package com.umss.dev.output;

import java.util.List;

import com.umss.dev.entity.Privilege;

public class RoleOutput {

	private int idRole;
	private String roleName;
	private String description;
	private List<Privilege> privilegios;
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<Privilege> getPrivilegios() {
		return privilegios;
	}
	public void setPrivilegios(List<Privilege> privilegios) {
		this.privilegios = privilegios;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
