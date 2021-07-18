package com.umss.dev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "DocumentQuotation")
@Table(name = "DOCUMENT_QUOTATION")
public class DocumentQuotation {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idDocumentQuotaion;
	@Column
	private String nameDocumenQuotaion;
	@Column
	private long sizeDocuemntQuotaion;
	@Column(columnDefinition = "longblob")
	private byte[] content;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "idReport",unique = true)
	private Report report;

	@JoinColumn(name = "idPriceQuotation",unique = true)
	@OneToOne(cascade =CascadeType.ALL)
	private PriceQuotation priceQuotation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPriceQuotationDetail")
	private PriceQuotationDetail priceQuotationDetail;
	
	public DocumentQuotation(String nameDocumenQuotaion, long sizeDocuemntQuotaion,
			byte[] content, Report report) {
		super();
		this.nameDocumenQuotaion = nameDocumenQuotaion;
		this.sizeDocuemntQuotaion = sizeDocuemntQuotaion;
		this.content = content;
		this.report = report;
	}

	public DocumentQuotation() {
		super();
	}

	public int getIdDocumentQuotaion() {
		return idDocumentQuotaion;
	}

	public void setIdDocumentQuotaion(int idDocumentQuotaion) {
		this.idDocumentQuotaion = idDocumentQuotaion;
	}

	public long getSizeDocuemntQuotaion() {
		return sizeDocuemntQuotaion;
	}

	public void setSizeDocuemntQuotaion(long sizeDocuemntQuotaion) {
		this.sizeDocuemntQuotaion = sizeDocuemntQuotaion;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getNameDocumenQuotaion() {
		return nameDocumenQuotaion;
	}

	public void setNameDocumenQuotaion(String nameDocumenQuotaion) {
		this.nameDocumenQuotaion = nameDocumenQuotaion;
	}

	public PriceQuotation getPriceQuotation() {
		return priceQuotation;
	}

	public void setPriceQuotation(PriceQuotation priceQuotation) {
		this.priceQuotation = priceQuotation;
	}

	public PriceQuotationDetail getPriceQuotationDetail() {
		return priceQuotationDetail;
	}

	public void setPriceQuotationDetail(PriceQuotationDetail priceQuotationDetail) {
		this.priceQuotationDetail = priceQuotationDetail;
	}
	
}
