package com.umss.dev.output;

import java.time.LocalDate;

public class PriceQuotationRequestOutput {

	private int idPriceQuotationRequest;
	private String link;
	private LocalDate deadline;
	
	public int getIdPriceQuotationRequest() {
		return idPriceQuotationRequest;
	}
	
	public void setIdPriceQuotationRequest(int idPriceQuotationRequest) {
		this.idPriceQuotationRequest = idPriceQuotationRequest;
	}
	
	/*public String getLink() {
		return link;
	}*/
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public LocalDate getDeadline() {
		return deadline;
	}
	
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	
}
