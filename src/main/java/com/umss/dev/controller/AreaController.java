package com.umss.dev.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.Business;
import com.umss.dev.output.BusinessOutput;
import com.umss.dev.repository.AreaRepository;
import com.umss.dev.service.AreaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/area")
public class AreaController {

	
	@Autowired
	private AreaService areaService;
	private AreaRepository areaRepository;
	private ModelMapper modelMapper;
	
	public AreaController(AreaService areaService, AreaRepository areaRepository, ModelMapper modelMapper) {
		
		this.areaService = areaService;
		this.areaRepository = areaRepository;
		this.modelMapper = modelMapper;
	}
	
	/*@GetMapping("/{id}")
	public ResponseEntity<?> spendingUnitRequest(@PathVariable (value = "id") Integer spendingUnitRequestId){	
		
		return ResponseEntity.ok(spendingUnitReqService.getSpendingUnitRequeste(spendingUnitRequestId)) ;
	}*/
	
	@GetMapping("/getBusinessesByAreaId/{id}")
	public Iterable<BusinessOutput> getBusinessByIdArea(@PathVariable (value = "id") Integer areaId){
		
		return areaService.getBusinessByIdArea(areaId);
		
	}
										
	@GetMapping("/getBusinessesByAreaName/{name}")
	public Iterable<BusinessOutput> getBusinessByAreaName(@PathVariable (value = "name") String areaName){
		
		return areaService.getBusinessByAreaName(areaName);
		
	}
	
	@GetMapping("/getAllBusiness")
	public Iterable<BusinessOutput> getAllBusiness(){
		
		return areaService.getAll();
	}
	
	@GetMapping("/getAllNameArea")
	public List<String> getAllNameArea(){
		return areaService.getallNameArea();
	}
}
