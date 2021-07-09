package com.umss.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.input.SpendingUnitRequestFilteredWithUserIdInput;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.service.AdministrationService;
import com.umss.dev.service.SpendingUnitRequestService;
import com.umss.dev.service.SpendingUnitService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/administration")
public class AdministrationController {
	
	@Autowired
	AdministrationService administrationService;
	
	public AdministrationController(AdministrationService administrationServ){
		this.administrationService = administrationServ;
	}
	
	@GetMapping()
	public Iterable<CompleteSpendingUnitRequestOutput> getAllWithoutDetailByOrder(){
		
		return administrationService.getAllWithoutDetailByOrder();	
	}
	
	@PermitAll
	@GetMapping("/getFilteredByUserIdSpendingUnitRequest")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllFilteredRequestsByUserId(@Valid @RequestBody SpendingUnitRequestFilteredWithUserIdInput filteredInput){
		System.out.println("----------USER ID----------:"+ filteredInput.getUserId() + "----------REQUEST STATUS----------:" + filteredInput.getSpendingUnitRequestStatus());
		return administrationService.getBySpendingUnitRequestStatusAndUserId(filteredInput.getUserId(), filteredInput.getSpendingUnitRequestStatus());
	}
	
	@PermitAll
	@GetMapping("/getFilteredSpendingUnitRequest/{status}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllFilteredRequestsBy(@PathVariable (value = "status") String status){
		System.out.println("----------REQUEST STATUS----------:" + status);
		return administrationService.getBySpendingUnitRequestStatus(status);
	}
}
