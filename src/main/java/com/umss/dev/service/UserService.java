package com.umss.dev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.User;
import com.umss.dev.output.RoleOutput;
import com.umss.dev.output.UserOutput;
import com.umss.dev.output.UserOutputNormalAtributes;
import com.umss.dev.repository.UserRepository;
import com.umss.dev.exception.DtoNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	private ModelMapper modelMapper;

	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
	    this.userRepository = userRepository;
	    this.modelMapper = modelMapper;
	   
	}
	
	public User getById(Integer userId) {
		User userAct = userRepository.findById(userId).orElse(null);
		
	    if (null == userAct) {
	    	
	        throw new DtoNotFoundException(UserOutputNormalAtributes.class.toString(), userId);
	    }
	  
	    return userAct;
	}
	
	public User save(User user) {
	    User persistedUser = userRepository.save(user);
	     
	     return persistedUser;
	}
	
	public Iterable<UserOutput> getAllUsers() {

		List <User> allUser = userRepository.findAll();
		List <UserOutput> allUsersByOrder = new ArrayList<UserOutput>();
		
		for(User a:allUser) {
			UserOutput newUser = new UserOutput();
			newUser.setIdUser(a.getIdUser());
			newUser.setName(a.getName());
			newUser.setRegistrationDate(a.getRegistrationDate());
			
			if(a.getUserRole().get(0).getSpendingUnit()!=null) {
				newUser.setSpendingUnit(a.getUserRole().get(0).getSpendingUnit().getNameUnit());
			}
			
			if(a.getUserRole().get(0).getRole().getRoleName() !=null) {
				newUser.setRole(a.getUserRole().get(0).getRole().getRoleName());
				newUser.setPrivileges(a.getUserRole().get(0).getRole().getPrivileges());
			}
            allUsersByOrder.add(newUser);
			
		}
		
		Collections.reverse(allUsersByOrder);
		
		return allUsersByOrder;	
			
	}
	
	
}
