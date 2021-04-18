package com.umss.dev.entity;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
@Data
@Entity
@Table(name = "SPENDING_UNIT_REQUEST")
public class SpendingUnitRequest {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idSpendingUnitRequest;
	
	@Column
	private String initials;
	@Column
	private LocalDate date;
	@Column
	private String status;
	@Column
	private String type;
	@Column
	private double estimatedAmount;
	@Column
	private String justification;
	
	@OneToMany(mappedBy = "request",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<RequestDetail> requestDetail;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idUserRole")
	@JsonBackReference
	private UserRole userRole;

}
