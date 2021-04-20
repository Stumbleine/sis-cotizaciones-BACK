package com.umss.dev.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Role;
import com.umss.dev.entity.UserRole;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.output.UserOutputNormalAtributes;
import com.umss.dev.output.UserRoleOutputNormalAtributes;
import com.umss.dev.repository.UserRepository;
import com.umss.dev.repository.UserRoleRepository;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	private ModelMapper modelMapper;

	public UserRoleService(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
	    this.userRoleRepository = userRoleRepository;
	    this.modelMapper = modelMapper;
	   
	}
	public UserRole getById(Integer userRoleId) {
		UserRole userRoleAct = userRoleRepository.findById(userRoleId).orElse(null);
	    if (null == userRoleAct) {
	        throw new DtoNotFoundException(UserRoleOutputNormalAtributes.class.toString(), userRoleId);
	    }
	  
	    return userRoleAct;
	}
	
	public UserRole save(UserRole userRole) {
		//Period converted = modelMapper.map(period,Period.class);
	    UserRole persistedUserRole = userRoleRepository.save(userRole);
	     
	     return persistedUserRole;
	}
	
}
