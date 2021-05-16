package com.umss.dev.entity;

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

//@Data
@Entity(name = "PriceQuotation")
@Table(name = "PRICE_QUOTATION")
public class PriceQuotation {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idPriceQuotation;
	@Column
	private String wayOfPayment;
	@Column
	private int garantyTerm;
	@Column
	private int deliveryTerm;
	@Column
	private String offValidation;
	@Column
	private Double total;

	/***/
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idPriceQuotationRequest")
	@JsonBackReference
	private PriceQuotationRequest priceQuotationRequest;
	
	@OneToMany(mappedBy = "priceQuotation",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<PriceQuotationDetail> priceQuotationDetail;
	
	@Column
	private String state;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idBusiness")
	private Business business;
	
	@Column(columnDefinition = "boolean default false")
	private boolean selected;
	
	public PriceQuotation(String wayOfPayment, int garantyTerm, int deliveryTerm, String offValidation, Double total,
			PriceQuotationRequest priceQuotationRequest, List<PriceQuotationDetail> priceQuotationDetail,
			String state) {
		super();
		this.wayOfPayment = wayOfPayment;
		this.garantyTerm = garantyTerm;
		this.deliveryTerm = deliveryTerm;
		this.offValidation = offValidation;
		this.total = total;
		this.priceQuotationRequest = priceQuotationRequest;
		this.priceQuotationDetail = priceQuotationDetail;
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public PriceQuotation(int idPriceQuotation, String wayOfPayment, int garantyTerm, int deliveryTerm,
			String offValidation, Double total, String state) {
		super();
		this.idPriceQuotation = idPriceQuotation;
		this.wayOfPayment = wayOfPayment;
		this.garantyTerm = garantyTerm;
		this.deliveryTerm = deliveryTerm;
		this.offValidation = offValidation;
		this.total = total;
		this.state = state;
	}

	public PriceQuotation() {
		super();
	}

	public int getIdPriceQuotation() {
		return idPriceQuotation;
	}

	public void setIdPriceQuotation(int idPriceQuotation) {
		this.idPriceQuotation = idPriceQuotation;
	}

	public String getWayOfPayment() {
		return wayOfPayment;
	}

	public void setWayOfPayment(String wayOfPayment) {
		this.wayOfPayment = wayOfPayment;
	}

	public int getGarantyTerm() {
		return garantyTerm;
	}

	public void setGarantyTerm(int garantyTerm) {
		this.garantyTerm = garantyTerm;
	}

	public int getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(int deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	public String getOffValidation() {
		return offValidation;
	}

	public void setOffValidation(String offValidation) {
		this.offValidation = offValidation;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public PriceQuotationRequest getPriceQuotationRequest() {
		return priceQuotationRequest;
	}

	public void setPriceQuotationRequest(PriceQuotationRequest priceQuotationRequest) {
		this.priceQuotationRequest = priceQuotationRequest;
	}

	public List<PriceQuotationDetail> getPriceQuotationDetail() {
		return priceQuotationDetail;
	}

	public void setPriceQuotationDetail(List<PriceQuotationDetail> priceQuotationDetail) {
		this.priceQuotationDetail = priceQuotationDetail;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}	
	
}
