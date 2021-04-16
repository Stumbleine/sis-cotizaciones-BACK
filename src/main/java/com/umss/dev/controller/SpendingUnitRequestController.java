package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.service.SpendingUnitRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/request")
public class SpendingUnitRequestController {
	
	@Autowired
	private SpendingUnitRequestService spendingUnitRequestservice;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SpendingUnitRequest spendingUnitRequest){
		//return ResponseEntity.status(HttpStatus.CREATED).body(spendingUnitRequestservice.save(spendingUnitRequest));
		SpendingUnitRequest request=spendingUnitRequest;
		spendingUnitRequestservice.save(request);
		return ResponseEntity.ok(request);
		
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
