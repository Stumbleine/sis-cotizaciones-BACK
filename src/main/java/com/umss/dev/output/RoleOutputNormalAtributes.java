package com.umss.dev.output;

import java.util.List;
import com.umss.dev.entity.UserRole;

public class RoleOutputNormalAtributes {

	private int idRole;
	private String roleName;
	private String description;
	private List<UserRole> userRole;
	
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
	
	public String getDescription() {
	
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<UserRole> getUserRole() {
	
		return userRole;
	}
	
	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	
}
