package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.service.SpendingUnitRequestService;

@RestController
@RequestMapping("/api/request")
public class SpendingUnitRequestController {
	
	@Autowired
	private SpendingUnitRequestService spendingUnitRequestservice;
	
	//Create a new SpendingUnitService
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SpendingUnitRequest spendingUnitRequest){
		return ResponseEntity.status(HttpStatus.CREATED).body(spendingUnitRequestservice.save(spendingUnitRequest));
		
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
