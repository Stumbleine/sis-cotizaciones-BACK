package com.umss.dev.controller;

import javax.annotation.security.PermitAll;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.service.SpendingUnitRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/request") // api/request
public class SpendingUnitRequestController { 
	
	@Autowired
	SpendingUnitRequestService spendingUnitReqService;
	
	public SpendingUnitRequestController(SpendingUnitRequestService spendingUnitReqServ){
		spendingUnitReqService = spendingUnitReqServ;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SpendingUnitRequest spendingUnitRequest){
		SpendingUnitRequest request=spendingUnitRequest;
		spendingUnitReqService.save(request);
		
		return ResponseEntity.ok(request);
	}
	
	@GetMapping()
	public Iterable<SpendingUnitRequest> getSpendingUnitRequests(){
		
		return spendingUnitReqService.getAll();
	}
	
	@GetMapping("/allRequestsDescOrder")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllReqByDescOrder(){
		
		return spendingUnitReqService.getAllWithoutDetailByOrder();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> spendingUnitRequest(@PathVariable (value = "id") Integer spendingUnitRequestId){	
		
		return ResponseEntity.ok(spendingUnitReqService.getSpendingUnitRequeste(spendingUnitRequestId)) ;
	}
	
	
}
