package com.umss.dev.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.output.UserOutput;
import com.umss.dev.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	
	public UserController() {
		
	}
	
	@GetMapping("/allUsers")
	public Iterable<UserOutput> getAllUsers(){
		
		return userService.getAllUsers();
	}
}
