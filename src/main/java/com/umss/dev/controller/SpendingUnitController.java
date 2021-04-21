package com.umss.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
import com.umss.dev.service.SpendingUnitService;



@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/spendingUnit")
public class SpendingUnitController {

	@Autowired
	SpendingUnitService spendingUnitService;
	
	public SpendingUnitController(SpendingUnitService spendingUnitServ){
		spendingUnitService = spendingUnitServ;
	}
	
	@GetMapping("/{id}")
		public Iterable<CompleteSpendingUnitRequestOutput> getAllReqById(@PathVariable (value = "id") Integer UserId){
			return spendingUnitService.getAllByIdWithoutDetailByOrder(UserId);
		}
	
}
