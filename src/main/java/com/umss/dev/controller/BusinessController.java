package com.umss.dev.controller;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

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
import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import com.umss.dev.entity.Area;
import com.umss.dev.entity.Business;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.input.BusinessInput;
import com.umss.dev.input.CreateBusinessInput;
import com.umss.dev.output.CompletePriceQuotation;
import com.umss.dev.service.AreaService;
import com.umss.dev.service.BusinessService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/business") // api/
public class BusinessController {

	@Autowired
	private BusinessService businessService;
	private AreaService areaService;

	public BusinessController(BusinessService businessService, AreaService areaService) {
		super();
		this.areaService = areaService;
		this.businessService = businessService;
	}
	/*@GetMapping("getById/{id}")
	public ResponseEntity<CompletePriceQuotation> priceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.findPriceQuotationById(idPriceQuotation));
	}*/
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Business> getByIdBusiness(@PathVariable (value = "id") Integer idBusiness){
			
			return ResponseEntity.ok( businessService.getByIdBusiness(idBusiness));
	}
	
	@GetMapping("/getLastBusiness")
	public Business getLastBusiness(){
		return businessService.getLastBusiness();
	}
	
	@PermitAll
	@PostMapping("/createEmpresa")
	public 	Business createBusiness(@Valid @RequestBody BusinessInput business) {
		Area areafound = areaService.getAreaByName(business.getNameArea());
		Business newBusiness = new Business();
		newBusiness.setName(business.getNameBusiness());
		newBusiness.setArea(areafound);
		return businessService.save(newBusiness);
	}
	
	@PostMapping("/registerBusiness")
	public ResponseEntity<?> create(@RequestBody CreateBusinessInput business){

		Business newBusiness= businessService.saveBusiness(business);
		
		return ResponseEntity.ok(newBusiness);
	}
	
}
