package com.umss.dev.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umss.dev.entity.Role;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.entity.User;
import com.umss.dev.entity.UserRole;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.SpendingUnitRequesteOutputAtributes;
import com.umss.dev.repository.SpendingUnitRequestRepository;

@Service
public class SpendingUnitRequestService {
	
	@Autowired
	private SpendingUnitRequestRepository spendingUnitRequestRepository;
	private ModelMapper modelMapper;
	private UserService userService;
	private RoleService roleService;
	private UserRoleService userRoleService;
	private int cont;
	
	public SpendingUnitRequestService(SpendingUnitRequestRepository spendingUnitRequestRepository, ModelMapper modelMapper, UserService userService, RoleService roleService,UserRoleService userRoleService) {
		this.spendingUnitRequestRepository = spendingUnitRequestRepository;
		this.userService= userService;
		this.roleService = roleService;
		this.userRoleService = userRoleService;
		this.modelMapper = modelMapper;
		cont = 1;
	}
	
	@Transactional
	public SpendingUnitRequest save(SpendingUnitRequest spendingUnitRequest) {
		//part of the automatic user save
		
		/*User newUser = new User();
		newUser.setName("Marco Antonio Buenavista gonzales");
		
		Role newRole = new Role();
		newRole.setRoleName("Spending Unit Representative");
		
		UserRole newUserRole = new UserRole();*/
		 
		/*if(cont == 1) {
			
			//newUserRole.setIdUserRole(1);
			newUserRole.setRole(newRole);
			newUserRole.setUser(newUser);
			userService.save(newUser);
			roleService.save(newRole);
			userRoleService.save(newUserRole);
			spendingUnitRequest.setUserRole(newUserRole);
			//roleService.save();
			cont++;
			
		}else {
			
			UserRole act = userRoleService.getById(1);
			spendingUnitRequest.setUserRole(act);
		}*/
		
		UserRole act = userRoleService.getById(1);
		spendingUnitRequest.setUserRole(act);
		
		return spendingUnitRequestRepository.save(spendingUnitRequest);//
	}
	
	public Iterable<SpendingUnitRequest> getAll(){
		List <SpendingUnitRequest> allSpendingUnitRequests = spendingUnitRequestRepository.findAll();	
		
		return allSpendingUnitRequests;
	}
	
	public Iterable<CompleteSpendingUnitRequestOutput> getAllWithoutDetailByOrder(){
		List <SpendingUnitRequest> allSpendingUnitRequests = spendingUnitRequestRepository.findAll();
		List <CompleteSpendingUnitRequestOutput> allSpendingUnitReqWithoutDetail = new ArrayList<CompleteSpendingUnitRequestOutput>();
		List<Integer> reqIds = new ArrayList<Integer>();
		
		for (SpendingUnitRequest req: allSpendingUnitRequests) {
			if (!req.getUserRole().getRole().equals(null)) {
				if(!req.getUserRole().getSpendingUnitRequest().isEmpty() || !req.getUserRole().getSpendingUnitRequest().equals(null)) {
					
					CompleteSpendingUnitRequestOutput newReq = new CompleteSpendingUnitRequestOutput();
					newReq.setIdSpendingUnitRequest(req.getIdSpendingUnitRequest());
					reqIds.add(req.getIdSpendingUnitRequest());
					newReq.setInitials(req.getInitials());
					newReq.setDate(req.getDate());
					newReq.setStatus(req.getStatus());
					newReq.setType(req.getType());
					newReq.setEstimatedAmount(req.getEstimatedAmount());
					newReq.setJustification(req.getJustification());
					newReq.setUserId(req.getUserRole().getUser().getIdUser());
					newReq.setUsername(req.getUserRole().getUser().getName());
					newReq.setRoleId(req.getUserRole().getRole().getIdRole());
					newReq.setRoleName(req.getUserRole().getRole().getRoleName());
					allSpendingUnitReqWithoutDetail.add(newReq);
					
				}
				
			}
			
		}
		
		Collections.sort(reqIds);
		Collections.reverse(reqIds);
		List <CompleteSpendingUnitRequestOutput> allSpendingUnitReqWithoutDetailByOrder = new ArrayList<CompleteSpendingUnitRequestOutput>();
		
		for(Integer actId: reqIds) {
			for(CompleteSpendingUnitRequestOutput actReq: allSpendingUnitReqWithoutDetail) {
				if(actId == actReq.getIdSpendingUnitRequest()) {
					
					allSpendingUnitReqWithoutDetailByOrder.add(actReq);
				}
				
			}
			
		}
		
		return allSpendingUnitReqWithoutDetailByOrder;	
	}
	
	public SpendingUnitRequesteOutputAtributes getSpendingUnitRequeste(int id) {
		Optional<SpendingUnitRequest> spendingUnitRequest = spendingUnitRequestRepository.findById(id);
		
		return getAtributes(spendingUnitRequest.get());
	}
	
	private SpendingUnitRequesteOutputAtributes getAtributes(SpendingUnitRequest spendingUnitRequest) {
		SpendingUnitRequesteOutputAtributes outputAtributes=new SpendingUnitRequesteOutputAtributes();
		outputAtributes.setUsername(spendingUnitRequest.getUserRole().getUser().getName());
		outputAtributes.setDate(spendingUnitRequest.getDate());
		outputAtributes.setEstimatedAmount(spendingUnitRequest.getEstimatedAmount());
		outputAtributes.setIdSpendingUnitRequest(spendingUnitRequest.getIdSpendingUnitRequest());
		outputAtributes.setInitials(spendingUnitRequest.getInitials());
		outputAtributes.setJustification(spendingUnitRequest.getJustification());
		outputAtributes.setRequestDetail(spendingUnitRequest.getRequestDetail());
		outputAtributes.setStatus(spendingUnitRequest.getStatus());
		outputAtributes.setType(spendingUnitRequest.getType());
		
		return outputAtributes;
	}
	
	public SpendingUnitRequest getSpendingUnitRequestNormal(int id) {
		Optional<SpendingUnitRequest> actRequest = spendingUnitRequestRepository.findById(id);
		
		return actRequest.get();
	}
	
}

