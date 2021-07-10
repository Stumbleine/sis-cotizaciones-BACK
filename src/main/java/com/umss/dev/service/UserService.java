package com.umss.dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.User;
import com.umss.dev.entity.UserRole;
import com.umss.dev.output.RoleOutput;
import com.umss.dev.output.UserOutput;
import com.umss.dev.output.UserOutputNormalAtributes;
import com.umss.dev.repository.RoleRepository;
import com.umss.dev.repository.SpendingUnitRepository;
import com.umss.dev.repository.UserRepository;
import com.umss.dev.repository.UserRoleRepository;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.input.UserInput;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private SpendingUnitRepository spendingUnitRepository;
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
	
	public UserInput save2(UserInput user) {
		User newUser=new User();
		newUser.setName(user.getName());
		newUser.setUserName(user.getUserName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setRegistrationDate(LocalDate.now());
	    userRepository.save(newUser);
	    putUserRole(user.getIdRole(),user.getIdSpendingUnit(),newUser);
	    return user;
	}
	
	private void putUserRole(int idRole,int idSpendingUnit, User user) {
		UserRole userRole=new UserRole();
		Role role= roleRepository.findById(idRole).get();
		SpendingUnit spendingUnit=spendingUnitRepository.findById(idSpendingUnit).get();
		userRole.setRole(role);
		userRole.setSpendingUnit(spendingUnit);
		userRole.setUser(user);
		userRoleRepository.save(userRole);	
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
				newUser.setSpendingUnit(a.getUserRole().get(0).getSpendingUnit().getAcronym());
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
	
	public String setResponsable(int id) {
		User user=userRepository.findById(id).get();
		user.setSelected(true);
		userRepository.save(user);
		return "New Responsable is "+user.getName();
	}
	
	public boolean noExistsUserName(String userName) {

		boolean result=true;
		List <User> allUser = userRepository.findAll();
		for(User a:allUser) {
			if(a.getUserName()!=null){
			if(a.getUserName().equalsIgnoreCase(userName)) {
				result=false;
			}}
		}
		return result;
	}
	
}
