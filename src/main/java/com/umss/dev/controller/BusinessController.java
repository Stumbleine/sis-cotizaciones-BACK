package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.Business;
import com.umss.dev.output.CompletePriceQuotation;
import com.umss.dev.service.BusinessService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/business") // api/request
public class BusinessController {

	@Autowired
	private BusinessService businessService;

	public BusinessController(BusinessService businessService) {
		super();
		this.businessService = businessService;
	}
	/*@GetMapping("getById/{id}")
	public ResponseEntity<CompletePriceQuotation> priceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.findPriceQuotationById(idPriceQuotation));
	}*/
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Business> priceQuotation(@PathVariable (value = "id") Integer idBusiness){
			
			return ResponseEntity.ok( businessService.getByIdBusiness(idBusiness));
	}
	
}
