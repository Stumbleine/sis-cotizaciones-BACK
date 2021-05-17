package com.umss.dev.output;

public class DocumentQuotationAtributesOutput {

	private String nameDocumenQuotaion;
	private long sizeDocuemntQuotaion;
	private byte[] content;
	
	public DocumentQuotationAtributesOutput() {
		super();
	}

	public String getNameDocumenQuotaion() {
		return nameDocumenQuotaion;
	}

	public void setNameDocumenQuotaion(String nameDocumenQuotaion) {
		this.nameDocumenQuotaion = nameDocumenQuotaion;
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
	
	
	
}
