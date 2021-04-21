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
@Entity(name = "Role")
@Table(name = "ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idRole;
	@Column
	private String roleName;
	@Column
	private String description;
	@OneToMany(mappedBy = "role",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<UserRole> userRole;

	public int getIdRole() {
		
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public List<UserRole> getUserRole() {
		
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
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

	@Override
	public String toString() {
		
		return "Role [idRole=" + idRole + ", roleName=" + roleName + ", description=" + description + ", userRole="
				+ userRole + "]";
	}

}
