package com.umss.dev.output;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import com.umss.dev.entity.PriceQuotationDetail;

public class PriceQuotationOutput {
	
	private int idPriceQuotation;
	private String state;
	private String nameBussiness;
	private String nameArea;
	private Double total;
	private LocalDate deadline;
	private List<PriceQuotationDetail> priceQuotationDetail;
	private String selected;
	private String wayOfPayment;
	private int garantyTerm;
	private int deliveryTerm;
	private String offValidation;
	private String commentary;
	
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
	
	public String getNameBussiness() {
		return nameBussiness;
	}
	
	public void setNameBussiness(String nameBussiness) {
		this.nameBussiness = nameBussiness;
	}
	
	public String getNameArea() {
		return nameArea;
	}
	
	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<PriceQuotationDetail> getPriceQuotationDetail() {
		return priceQuotationDetail;
	}

	public void setPriceQuotationDetail(List<PriceQuotationDetail> priceQuotationDetail) {
		this.priceQuotationDetail = priceQuotationDetail;
		for(int i=0;i<priceQuotationDetail.size();i++) {
			priceQuotationDetail.get(i).setDocumentQuotation(null);
		}
	}

	/*public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}*/

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
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

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
}
