package com.umss.dev.output;

import javax.persistence.Column;

public class ReportOutput {
	
	private String descripcion;
	private String nameBusiness;
	private String nameArea;
	private double total;
	
	private DocumentQuotationAtributesOutput documentQuotationAtributesOutput;
	
	public ReportOutput() {
		super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	public DocumentQuotationAtributesOutput getDocumentQuotationAtributesOutput() {
		return documentQuotationAtributesOutput;
	}

	public void setDocumentQuotationAtributesOutput(DocumentQuotationAtributesOutput documentQuotationAtributesOutput) {
		this.documentQuotationAtributesOutput = documentQuotationAtributesOutput;
	}

	public String getNameBusiness() {
		return nameBusiness;
	}

	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}

	public String getNameArea() {
		return nameArea;
	}

	public void setNameArea(String nameArea) {
		this.nameArea = nameArea;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
