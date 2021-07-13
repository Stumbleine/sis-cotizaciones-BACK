package com.umss.dev.controller;

import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.input.BusinessInput;
import com.umss.dev.input.SpendingUnitRequestFilteredWithUserIdInput;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.SpendingUnitOutput;
import com.umss.dev.service.SpendingUnitService;



@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/spendingUnit")
public class SpendingUnitController {

	@Autowired
	SpendingUnitService spendingUnitService;
	@Autowired
	private ModelMapper modelMapper;
	
	public SpendingUnitController(SpendingUnitService spendingUnitServ, ModelMapper modelMapper){
		spendingUnitService = spendingUnitServ;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping()
	public Iterable<CompleteSpendingUnitRequestOutput> getAllWithoutDetailByOrder(){
		
		return spendingUnitService.getAllWithoutDetailByOrder();	
	}
	
	@PreAuthorize("hasRole('RUG')")	
	@GetMapping("/{id}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllReqById(@PathVariable (value = "id") Integer UserId){
		return spendingUnitService.getAllByIdWithoutDetailByOrder(UserId);
	}
	@GetMapping("/{id}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllReqById(@PathVariable (value = "id") Integer UserId){
		return spendingUnitService.getAllByIdWithoutDetailByOrder(UserId);
	}
	@PreAuthorize("hasRole('RAF') or hasRole('RUG')")	
	@PostMapping("/registerSpendingUnit")
	public ResponseEntity<?> createSpendingUnit(@RequestBody SpendingUnit spendingUnit){
		
		return ResponseEntity.ok(spendingUnitService.save(spendingUnit));
	}
	@PreAuthorize("hasRole('RAF') or hasRole('RUG')")		
	@GetMapping("/allSpendingUnits")
	public Iterable<SpendingUnitOutput> getSpendingUnits(){
		return spendingUnitService.getAllSpendingUnitsByOrder();
	}
	
	@PermitAll
	@GetMapping("/getFilteredSpendingUnitRequest")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllFilteredRequests(@Valid @RequestBody  SpendingUnitRequestFilteredWithUserIdInput filteredInput){
		System.out.println("----------USER ID----------:"+ filteredInput.getUserId() + "----------REQUEST STATUS----------:" + filteredInput.getSpendingUnitRequestStatus());
		return spendingUnitService.getBySpendingUnitRequestStatus(filteredInput.getUserId(), filteredInput.getSpendingUnitRequestStatus());
	}
	
	@PermitAll
	@GetMapping("/getFilteredSpendingUnitRequest/{status}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllFilteredRequestsBy(@PathVariable (value = "status") String status){
		System.out.println("----------REQUEST STATUS----------:" + status);
		return spendingUnitService.getBySpendingUnitRequestStatus(status);
	}
	
}
