package com.umss.dev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
@Table(name = "REQUEST_DETAIL")
public class RequestDetail {

		@Id
		@GeneratedValue(strategy  = GenerationType.IDENTITY)
		private int idRequestDetail;
		
		@Column
		private int quantity;
		@Column
		private String unit;
		@Column
		private String description;
		
		@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
		@JoinColumn(name="idSpendingUnitRequest")
		@JsonBackReference
		private SpendingUnitRequest request;
}
