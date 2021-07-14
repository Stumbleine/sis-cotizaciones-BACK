package com.umss.dev.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.UserSis;
import com.umss.dev.input.UserInput;
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
	@PreAuthorize("hasRole('ADMIN')")	
	@GetMapping("/allUsers")
	public Iterable<UserOutput> getAllUsers(){
		
		return userService.getAllUsers();
	}
	@PreAuthorize("hasRole('ADMIN')")	
	@PostMapping("/registerUser")
	public ResponseEntity<?> createUser(@RequestBody UserInput user){
		
		return ResponseEntity.ok(userService.save2(user));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/responsable/{id}")
	public ResponseEntity<String> setResponsable(@PathVariable Integer id){
		return ResponseEntity.ok(userService.setResponsable(id));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/uniqueUserName/{userName}")
	public ResponseEntity<?> createUserName(@PathVariable String userName){
		
		return ResponseEntity.ok(userService.noExistsUserName(userName));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/updateDataUser/{id}")
	public ResponseEntity<?> setDataUser(@PathVariable Integer id,@RequestBody UserInput user){
		return ResponseEntity.ok(userService.setUser(id, user));
	}
}
