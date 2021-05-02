package com.umss.dev.output;

import lombok.Data;

public class CompletePriceQuotationOutput {

	int idPriceQuotation;
	// datos de la empresas

	public CompletePriceQuotationOutput() {

	}	
	
	public int getIdPriceQuotation() {
		return idPriceQuotation;
	}

	public void setIdPriceQuotation(int idPriceQuotation) {
		this.idPriceQuotation = idPriceQuotation;
	}
	
	
}
