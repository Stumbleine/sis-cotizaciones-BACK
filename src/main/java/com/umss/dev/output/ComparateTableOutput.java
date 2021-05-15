package com.umss.dev.output;

import java.util.List;

import com.umss.dev.entity.RequestDetail;

public class ComparateTableOutput {

	List<RequestDetail> detail;
	List<BusinessSubTotal> comparateTableOutputs;
	
	
	
	
	public List<BusinessSubTotal> getComparateTableOutputs() {
		return comparateTableOutputs;
	}
	public void setComparateTableOutputs(List<BusinessSubTotal> comparateTableOutputs) {
		this.comparateTableOutputs = comparateTableOutputs;
	}
	public List<RequestDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<RequestDetail> detail) {
		this.detail = detail;
	}
	
	
}
