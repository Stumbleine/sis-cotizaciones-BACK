package com.umss.dev.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.output.BusinessOutput;
import com.umss.dev.output.RoleOutput;
import com.umss.dev.service.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/role")

public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private ModelMapper modelMapper;
	
	public RoleController() {
		
	}
	@PreAuthorize("hasRole('ADMIN')")	
	@GetMapping("/allRoles")
	public Iterable<RoleOutput> getAllRoles(){
		
		return roleService.getAllRoles();
	}
}
