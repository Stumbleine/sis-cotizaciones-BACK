package com.umss.dev.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.output.PriceQuotationRequestOutput;
import com.umss.dev.service.PriceQuotationRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/req-content")  // api/req-content
public class PriceQuotationRequestController {
	
	@Autowired
	PriceQuotationRequestService priceQuotationRequestService;
	
	@GetMapping("/{id}/quotation")
	public  Iterable<PriceQuotationOutput> getPriceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return  priceQuotationRequestService.getPriceQuotation(idPriceQuotation);	
	}
	/*
	 @GetMapping("/{id}/quotation")
	public  Iterable<PriceQuotationOutput> getPriceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return  priceQuotationRequestService.getPriceQuotation(idPriceQuotation);	
	}
	 **/
	
	@PutMapping("/updateDeadLine/{id}")
	public ResponseEntity<?> updateQuotation(@PathVariable Integer id, @RequestBody PriceQuotationRequest PriceQuotationRequest) {
		
		PriceQuotationRequestOutput updateRequets=priceQuotationRequestService.save(id,PriceQuotationRequest);

		return ResponseEntity.ok(updateRequets);
	}

}
