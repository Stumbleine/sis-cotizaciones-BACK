package com.umss.dev.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity(name = "UserRole")
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idUserRole;	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idUser")
	private User user;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idRole")
	private Role role;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idSpendingUnit")
	private SpendingUnit spendingUnit;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idAdministration")
	private Administration administration;
	@OneToMany(mappedBy = "userRole",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<SpendingUnitRequest> spendingUnitRequest;

	public int getIdUserRole() {
		
		return idUserRole;
	}

	public void setIdUserRole(int idUserRole) {
		this.idUserRole = idUserRole;
	}

	public User getUser() {
		
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SpendingUnit getSpendingUnit() {
		
		return spendingUnit;
	}

	public void setSpendingUnit(SpendingUnit spendingUnit) {
		this.spendingUnit = spendingUnit;
	}

	public Administration getAdministration() {
		
		return administration;
	}

	public void setAdministration(Administration administration) {
		this.administration = administration;
	}

	public List<SpendingUnitRequest> getSpendingUnitRequest() {
		
		return spendingUnitRequest;
	}

	public void setSpendingUnitRequest(List<SpendingUnitRequest> spendingUnitRequest) {
		this.spendingUnitRequest = spendingUnitRequest;
	}

	@Override
	public String toString() {
		
		return "UserRole [idUserRole=" + idUserRole + ", user=" + user + ", role=" + role + ", spendingUnit="
				+ spendingUnit + ", administration=" + administration + ", spendingUnitRequest=" + spendingUnitRequest
				+ "]";
	}
	
}
