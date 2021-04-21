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
@Entity (name = "RequestDetail")
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

		public int getIdRequestDetail() {
			return idRequestDetail;
		}

		public void setIdRequestDetail(int idRequestDetail) {
			this.idRequestDetail = idRequestDetail;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getUnit() {
			
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
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

		@Override
		public String toString() {
			
			return "RequestDetail [idRequestDetail=" + idRequestDetail + ", quantity=" + quantity + ", unit=" + unit
					+ ", description=" + description + ", request=" + request + "]";
		}
				
}
