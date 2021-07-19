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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.input.BusinessInput;
import com.umss.dev.input.SpendingUnitRequestFilteredWithUserIdInput;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.SpendingUnitOutput;
import com.umss.dev.service.SpendingUnitService;



@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
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
	
	@PreAuthorize("hasRole('VER_DETALLE_PEDIDO')")	
	@GetMapping("/allRequest/{id}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllWithoutDetailByOrder(@PathVariable (value = "id") Integer userId){
		
		return spendingUnitService.getAllByFaculty(userId);	
	}
	
	@PreAuthorize("hasRole('VER_PEDIDO')")	
	@GetMapping("/{id}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllReqById(@PathVariable (value = "id") Integer UserId){
		return spendingUnitService.getAllByIdWithoutDetailByOrder(UserId);
	}
	
	@PreAuthorize("hasRole('ADMIN')")	
	@PostMapping("/registerSpendingUnit")
	public ResponseEntity<?> createSpendingUnit(@RequestBody SpendingUnit spendingUnit){
		
		return ResponseEntity.ok(spendingUnitService.save(spendingUnit));
	}
	@PreAuthorize("hasRole('ADMIN')")		
	@GetMapping("/allSpendingUnits")
	public Iterable<SpendingUnitOutput> getSpendingUnits(){
		return spendingUnitService.getAllSpendingUnitsByOrder();
	}
	
	@PreAuthorize("hasRole('VER_PEDIDO')")	
	@PermitAll
	@GetMapping("/getFilteredSpendingUnitRequest")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllFilteredRequests(@Valid @RequestBody  SpendingUnitRequestFilteredWithUserIdInput filteredInput){
		System.out.println("----------USER ID----------:"+ filteredInput.getUserId() + "----------REQUEST STATUS----------:" + filteredInput.getSpendingUnitRequestStatus());
		return spendingUnitService.getBySpendingUnitRequestStatus(filteredInput.getUserId(), filteredInput.getSpendingUnitRequestStatus());
	}
	
	@PreAuthorize("hasRole('VER_DETALLE_PEDIDO')")	
	@PermitAll
	@GetMapping("/getFilteredSpendingUnitRequest/{status}")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllFilteredRequestsBy(@PathVariable (value = "status") String status){
		System.out.println("----------REQUEST STATUS----------:" + status);
		return spendingUnitService.getBySpendingUnitRequestStatus(status);
	}
	
	@PreAuthorize("hasRole('TOMAR_DECISION')")
	@PutMapping("/updateBudget")
	public ResponseEntity<?> setBudget(@RequestParam("budget") Double budget){
		return ResponseEntity.ok(spendingUnitService.setBudget(budget));
	}

	@PreAuthorize("hasRole('VER_DETALLE_PEDIDO') or hasRole('VER_PEDIDO')")
	@GetMapping("/getBudget")
	public ResponseEntity<?> getBudget(){
		return ResponseEntity.ok(spendingUnitService.getBudget());
	}
	
}
