package com.umss.dev.output;

import java.util.List;

import com.umss.dev.entity.Business;
import com.umss.dev.entity.PriceQuotationDetail;
import com.umss.dev.entity.PriceQuotationRequest;

public class CompletePriceQuotation {

	private int idPriceQuotation;
	private String state;
	private Double total;
	private String wayOfPayment;
	private int garantyTerm;
	private String offValidation;
	private Boolean selected;
	private String commentary;
	private String businessCompanyName;
	private int deliveryTerm;
	private List<PriceQuotationDetail> priceQuotationDetail;
	//private PriceQuotationRequest priceQuotationRequest;
	private BusinessOutput business;
	
	public CompletePriceQuotation() {}

	public int getIdPriceQuotation() {
		return idPriceQuotation;
	}

	public void setIdPriceQuotation(int idPriceQuotation) {
		this.idPriceQuotation = idPriceQuotation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public String getOffValidation() {
		return offValidation;
	}

	public void setOffValidation(String offValidation) {
		this.offValidation = offValidation;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<PriceQuotationDetail> getPriceQuotationDetail() {
		return priceQuotationDetail;
	}

	public void setPriceQuotationDetail(List<PriceQuotationDetail> priceQuotationDetail) {
		this.priceQuotationDetail = priceQuotationDetail;
	}

	/*public PriceQuotationRequest getPriceQuotationRequest() {
		return priceQuotationRequest;
	}

	public void setPriceQuotationRequest(PriceQuotationRequest priceQuotationRequest) {
		this.priceQuotationRequest = priceQuotationRequest;
	}*/

	public BusinessOutput getBusiness() {
		return business;
	}

	public void setBusiness(BusinessOutput business) {
		this.business = business;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	public String getBusinessCompanyName() {
		return businessCompanyName;
	}

	public void setBusinessCompanyName(String businessCompanyName) {
		this.businessCompanyName = businessCompanyName;
	}

	public int getDeliveryTerm() {
		return deliveryTerm;
	}

	public void setDeliveryTerm(int deliveryTerm) {
		this.deliveryTerm = deliveryTerm;
	}

	
	
	
	
}
