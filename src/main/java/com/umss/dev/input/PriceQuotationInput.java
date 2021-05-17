package com.umss.dev.input;

import java.util.List;
import javax.persistence.Column;
import com.umss.dev.entity.PriceQuotationDetail;
import lombok.Data;
@Data
public class PriceQuotationInput {
	/*
{
    "idBusiness":1,
    "wayOfPayment" : "",
    "garantyTerm" : ,
    "deliveryTerm" : ,
    "offValidation" : "",
    "total" : ,
    "priceQuotationDetail":[
        {
            "quantity" : 12,
            "unit" : "maquinaria",
            "description" : "maquinaria industrial",
            "unitPrice" : 500,
            "totalPrice" : 50000

        },
        {
            "quantity" : 15,
            "unit" : "balones",
            "description" : "practicas de futbol",
            "unitPrice" : 10,
            "totalPrice" : 150

        }
    ]
     

}*/

	private int idBusiness;
	private String wayOfPayment;
	private int garantyTerm;
	private int deliveryTerm;
	private String offValidation;
	private Double total;
	private List<PriceQuotationDetail> priceQuotationDetail;
	
	public PriceQuotationInput() {}

	public int getBusinessId() {
		return idBusiness;
	}

	public void setBusinessId(int businessId) {
		this.idBusiness = businessId;
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
	
	
}
