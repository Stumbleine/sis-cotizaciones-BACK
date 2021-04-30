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
//@Data
@Entity (name = "PriceQoutationDetail")
@Table(name = "PRICE_QOUTATION_DETAIL")

public class PriceQoutationDetail {

		@Id
		@GeneratedValue(strategy  = GenerationType.IDENTITY)
		private int idPriceQoutationDetail;
		@Column
		private int quantity;
		@Column
		private String unit;
		@Column
		private String description;
		@Column
		private float unitPrice;
		@Column
		private float totalPrice;
		/*@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
		@JoinColumn(name="idPriceQuatation")
		@JsonBackReference
		private PriceQoutation priceQuatation;*/
		
		public int getIdPriceQoutationDetail() {
			return idPriceQoutationDetail;
		}
		
		public void setIdPriceQoutationDetail(int idPriceQoutationDetail) {
			this.idPriceQoutationDetail = idPriceQoutationDetail;
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
		
		public float getUnitPrice() {
			return unitPrice;
		}
		
		public void setUnitPrice(float unitPrice) {
			this.unitPrice = unitPrice;
		}
		
		public float getTotalPrice() {
			return totalPrice;
		}
		
		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}
		
		/*public PriceQoutation priceQoutation() {
			return priceQoutation;
		}
		
		public void setPriceQoutation(PriceQoutation priceQoutation) {
			this.priceQoutation = priceQoutation;
		}*/
			
}
