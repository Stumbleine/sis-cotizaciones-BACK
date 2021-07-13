package com.umss.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.security.PermitAll;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.service.AdministrationService;
import com.umss.dev.service.SpendingUnitRequestService;
import com.umss.dev.service.SpendingUnitService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/administration")
public class AdministrationController {
	
	@Autowired
	AdministrationService administrationService;
	
	public AdministrationController(AdministrationService administrationServ){
		this.administrationService = administrationServ;
	}
	
	@PreAuthorize("hasRole('RAF') or hasRole('RUG')")	
	@GetMapping()
	public Iterable<CompleteSpendingUnitRequestOutput> getAllWithoutDetailByOrder(){
		
		return administrationService.getAllWithoutDetailByOrder();	
	}

}
