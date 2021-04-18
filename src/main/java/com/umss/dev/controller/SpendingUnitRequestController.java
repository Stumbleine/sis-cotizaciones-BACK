package com.umss.dev.controller;

import javax.annotation.security.PermitAll;


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
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.service.SpendingUnitRequestService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")

//@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
//@RequestMapping("/api/request")
@RequestMapping("/request") // api/request
public class SpendingUnitRequestController { 
	
	@Autowired
	SpendingUnitRequestService spendingUnitReqService;
	
	public SpendingUnitRequestController(SpendingUnitRequestService spendingUnitReqServ){
		spendingUnitReqService = spendingUnitReqServ;
	}
	
	//
	//private SpendingUnitRequestService spendingUnitRequestservice;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SpendingUnitRequest spendingUnitRequest){
		//return ResponseEntity.status(HttpStatus.CREATED).body(spendingUnitRequestservice.save(spendingUnitRequest));
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
	
	
	
	
	
	
	 
	
	
	/*Read a SpendingUnitService
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Integer id){
		Optional<SpendingUnitRequest> oRequest= spendingUnitRequestService.findById(id);
		
		if(!oRequest.isPresent()){
		  return ResponseEntity.notFound().build(); //Return 404
		}

		return ResponseEntity.ok(oRequest); //When there's a request
	}*/

}
