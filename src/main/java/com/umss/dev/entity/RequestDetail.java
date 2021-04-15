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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "REQUEST_DETAIL")
public class RequestDetail {

		@Id
		@GeneratedValue(strategy  = GenerationType.AUTO)
		@Column
		private int idRequestDetail;
		
		@Column
		private String name;
		@Column
		private int quantity;
		@Column
		private String description;
		
		@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
		@JoinColumn(name="id_spending_unit_request",referencedColumnName = "idSpendingUnitRequest")
		@JsonBackReference
		private SpendingUnitRequest request;
		
		public  RequestDetail(String name, int quantity, String description) {
			super();
			this.name = name;
			this.quantity =quantity;
			this.description =description;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public SpendingUnitRequest getRequest() {
			return request;
		}

		public void setRequest(SpendingUnitRequest request) {
			this.request = request;
		}


}
