package com.umss.dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.UserSis;
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
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
	    this.userRepository = userRepository;
	    this.modelMapper = modelMapper;
	   
	}
	
	public UserSis getById(Integer userId) {
		UserSis userAct = userRepository.findById(userId).orElse(null);
		
	    if (null == userAct) {
	    	
	        throw new DtoNotFoundException(UserOutputNormalAtributes.class.toString(), userId);
	    }
	  
	    return userAct;
	}
	
	public UserSis save(UserSis user) {
	    UserSis persistedUser = userRepository.save(user);
	     
	     return persistedUser;
	}
	
	public UserInput save2(UserInput user) {
		UserSis newUser=new UserSis();
		newUser.setName(user.getName());
		newUser.setUserName(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(encoder.encode(user.getPassword()));        System.out.println("The password's user is "+ newUser.getPassword());
		newUser.setRegistrationDate(LocalDate.now());
	    userRepository.save(newUser);
	    putUserRole(user.getIdRole(),user.getIdSpendingUnit(),newUser);
	    return user;
	}
	
	private void putUserRole(int idRole,int idSpendingUnit, UserSis user) {
		UserRole userRole=new UserRole();
		Role role= roleRepository.findById(idRole).get();
		SpendingUnit spendingUnit=spendingUnitRepository.findById(idSpendingUnit).get();
		userRole.setRole(role);
		userRole.setSpendingUnit(spendingUnit);
		userRole.setUser(user);
		userRoleRepository.save(userRole);	
	}
	
	public Iterable<UserOutput> getAllUsers() {

		List <UserSis> allUser = userRepository.findAll();
		List <UserOutput> allUsersByOrder = new ArrayList<UserOutput>();
		
		for(UserSis a:allUser) {
			UserOutput newUser = new UserOutput();
			newUser.setIdUser(a.getIdUser());
			newUser.setName(a.getName());
			newUser.setRegistrationDate(a.getRegistrationDate());
			newUser.setEmail(a.getEmail());
			if (!a.getUserRole().isEmpty()) {
				if(a.getUserRole().get(0).getSpendingUnit()!=null) {
					newUser.setSpendingUnit(a.getUserRole().get(0).getSpendingUnit().getAcronym());
				}

				System.out.println("USERRR: "+a.getName());
				if(a.getUserRole().get(0).getRole().getRoleName() !=null) {
					newUser.setRole(a.getUserRole().get(0).getRole().getRoleName());
					newUser.setPrivileges(a.getUserRole().get(0).getRole().getPrivileges());
				}
			}
            allUsersByOrder.add(newUser);
			
		}
		
		Collections.reverse(allUsersByOrder);
		
		return allUsersByOrder;	
			
	}
	
	public String setResponsable(int id) {
		UserSis user=userRepository.findById(id).get();
		user.setSelected(true);
		userRepository.save(user);
		return user.getName();
	}
	
	public boolean noExistsUserName(String userName) {
		
		boolean result=true;
		List <UserSis> allUser = userRepository.findAll();
		for(UserSis a:allUser) {
			if(a.getUserName()!=null){
			if(a.getUserName().equalsIgnoreCase(userName)) {
				result=false;
			}}
		}
		return result;
	}
	
	public UserInput setUser(int id,UserInput user) {
		UserSis updateUser=userRepository.findById(id).get();
		if(!user.getEmail().isEmpty()) {
			updateUser.setEmail(user.getEmail());
		}
		if(!user.getName().isEmpty()) {
			updateUser.setName(user.getName());
		}
		if(!user.getPassword().isEmpty()) {
			updateUser.setPassword(encoder.encode(user.getPassword()));
		}
		if(!user.getUsername().isEmpty()) {
			updateUser.setUserName(user.getUsername());
		}
		//if(user.getIdRole().) {
			UserRole userRole=updateUser.getUserRole().get(0);
			Role role=roleRepository.findById(user.getIdRole()).get();
			userRole.setRole(role);
			List<UserRole> userRoles=new ArrayList<UserRole>();
			userRoles.add(userRole);
			updateUser.setUserRole(userRoles);
		//}
		
		userRepository.save(updateUser);
		return user;

	}
}
