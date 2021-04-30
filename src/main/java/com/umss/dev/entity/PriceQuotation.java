package com.umss.dev.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "PriceQuotation")
@Table(name = "PRICE_QUOTATION")
public class PriceQuotation {

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private int idPriceQuotation;
	@Column
	private String wayOfPayment;
	@Column
	private int garantyTerm;
	@Column
	private int deliveryTerm;
	@Column
	private String offValidation;
	@Column
	private Double total;
	/*
	 * 
	 *@OneToMany(mappedBy = "",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	 *@JsonManagedReference
	 *private List<PriceQuotationDetail> priceQuotationDetail;
	*/
	
	public PriceQuotation() {
		super();
	}

}
