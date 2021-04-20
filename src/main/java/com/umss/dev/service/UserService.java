package com.umss.dev.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.umss.dev.entity.User;
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
	
	
	///////////////////////////////////////////////////////////
	public User getById(Integer userId) {
		User userAct = userRepository.findById(userId).orElse(null);
	    if (null == userAct) {
	        throw new DtoNotFoundException(UserOutputNormalAtributes.class.toString(), userId);
	    }
	  
	    return userAct;
	}
	
	public User save(User user) {
		//Period converted = modelMapper.map(period,Period.class);
	    User persistedUser = userRepository.save(user);
	     
	     return persistedUser;
	}
	
}
