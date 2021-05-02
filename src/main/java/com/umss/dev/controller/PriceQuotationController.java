package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.output.CompletePriceQuotationOutput;
import com.umss.dev.service.PriceQuotationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/quotation")
public class PriceQuotationController {

	@Autowired
	private PriceQuotationService priceQuotationService;
	
	@PostMapping
	public ResponseEntity<PriceQuotation> create(@RequestBody PriceQuotation priceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.save(priceQuotation));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompletePriceQuotationOutput> priceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.getPriceQuotation(idPriceQuotation));
	}

}
