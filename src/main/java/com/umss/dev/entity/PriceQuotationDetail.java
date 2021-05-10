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

public class PriceQuotationDetail {

		@Id
		@GeneratedValue(strategy  = GenerationType.IDENTITY)
		private int idPriceQuotationDetail;
		@Column
		private int quantity;
		@Column
		private String unit;
		@Column
		private String description;
		@Column
		private Float unitPrice;
		@Column
		private Float totalPrice;
		@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
		@JoinColumn(name="idPriceQuotation")
		@JsonBackReference
		private PriceQuotation priceQuotation;
		
		public int getIdPriceQuotationDetail() {
			return idPriceQuotationDetail;
		}
		
		public void setIdPriceQuotationDetail(int idPriceQuotationDetail) {
			this.idPriceQuotationDetail = idPriceQuotationDetail;
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
		
		public Float getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(Float unitPrice) {
			this.unitPrice = unitPrice;
		}

		public Float getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Float totalPrice) {
			this.totalPrice = totalPrice;
		}

		public PriceQuotation getPriceQuotation() {
			return priceQuotation;
		}
		
		public void setPriceQuotation(PriceQuotation priceQuotation) {
			this.priceQuotation = priceQuotation;
		}
			
}
