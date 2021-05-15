package com.umss.dev.output;

import java.util.List;

public class BusinessSubTotal {

	private String nameBusiness;
	private List<Integer> SubTotal;
	
	
	
	public BusinessSubTotal() {
		super();
	}
	
	public String getNameBusiness() {
		return nameBusiness;
	}
	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}
	public List<Integer> getSubTotal() {
		return SubTotal;
	}
	public void setSubTotal(List<Integer> subTotal) {
		SubTotal = subTotal;
	}
	
	
}
