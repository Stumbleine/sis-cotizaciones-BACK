package com.umss.dev.output;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
	
	
}
