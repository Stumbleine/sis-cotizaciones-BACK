package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.service.PriceQuotationService;

@RestController
@RequestMapping("/quotation")
public class PriceQuotationController {

	@Autowired
	private PriceQuotationService priceQuotationService;
	
	@PostMapping
	public ResponseEntity<PriceQuotation> create(@RequestBody PriceQuotation priceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.save(priceQuotation));
	}

}
