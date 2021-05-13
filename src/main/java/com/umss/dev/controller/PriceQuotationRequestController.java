package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.service.PriceQuotationRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/req-content")  // api/req-content
public class PriceQuotationRequestController {
	
	@Autowired
	PriceQuotationRequestService priceQuotationRequestService;
	
	@GetMapping("/{id}/quotation")
	public  Iterable<PriceQuotationOutput> getPriceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return  priceQuotationRequestService.getPriceQuotation(idPriceQuotation);	
	}

}
