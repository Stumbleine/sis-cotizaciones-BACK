package com.umss.dev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umss.dev.entity.SpendingUnit;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.entity.UserRole;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.SpendingUnitOutput;
import com.umss.dev.output.UserOutputAtributes;
import com.umss.dev.output.UserOutputNormalAtributes;
import com.umss.dev.repository.SpendingUnitRepository;
import com.umss.dev.repository.SpendingUnitRequestRepository;


@Service
public class SpendingUnitService {

	@Autowired
	private SpendingUnitRepository spendingUnitRepository;
	private ModelMapper modelMapper;
	private SpendingUnitRequestRepository spendingUnitRequestRepository;
	
	
	public SpendingUnitService(SpendingUnitRepository spendingUnitRepository, ModelMapper modelMapper, SpendingUnitRequestRepository spendingUnitRequestRepository) {
		this.spendingUnitRepository = spendingUnitRepository;
		this.modelMapper = modelMapper;
		this.spendingUnitRequestRepository = spendingUnitRequestRepository; 
		   
	}
	
	public Iterable<CompleteSpendingUnitRequestOutput>getAllByIdWithoutDetailByOrder(Integer UserId){
		Iterable <CompleteSpendingUnitRequestOutput> allByIdReq = getAllWithoutDetailByOrder();
		List<CompleteSpendingUnitRequestOutput>listAllReqDesc= StreamSupport.stream(allByIdReq.spliterator(), false)
        .collect(Collectors.toList());
		List<CompleteSpendingUnitRequestOutput> listAllById = new ArrayList<CompleteSpendingUnitRequestOutput>();
		
		for(int i=0; i<listAllReqDesc.size();i++ ) {
			
			CompleteSpendingUnitRequestOutput actReq = listAllReqDesc.get(i);
			
			if(actReq.getUserId() == UserId) {
				
				listAllById.add(actReq);
			}
			
		}
		
		return listAllById;
	}
	
	public Iterable<CompleteSpendingUnitRequestOutput> getAllWithoutDetailByOrder(){
		List <SpendingUnitRequest> allSpendingUnitRequests = spendingUnitRequestRepository.findAll();
		List <CompleteSpendingUnitRequestOutput> allSpendingUnitReqWithoutDetail = new ArrayList<CompleteSpendingUnitRequestOutput>();
		List<Integer> reqIds = new ArrayList<Integer>();
		List <CompleteSpendingUnitRequestOutput> allSpendingUnitReqWithoutDetailByOrder = new ArrayList<CompleteSpendingUnitRequestOutput>();
		
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
	
		for(Integer actId: reqIds) {
			for(CompleteSpendingUnitRequestOutput actReq: allSpendingUnitReqWithoutDetail) {
				if(actId == actReq.getIdSpendingUnitRequest()) {
					allSpendingUnitReqWithoutDetailByOrder.add(actReq);
				}
				
			}
			
		}
		
		return allSpendingUnitReqWithoutDetailByOrder;		
	}
	
	// SpendingUnitRequests filtered by UserId & RequestStatus
	public Iterable<CompleteSpendingUnitRequestOutput> getBySpendingUnitRequestStatus(int userId, String status){
		List <CompleteSpendingUnitRequestOutput> listSpendingUnitRequestByUserId = StreamSupport.stream(getAllByIdWithoutDetailByOrder(userId).spliterator(), false).collect(Collectors.toList());
		List <CompleteSpendingUnitRequestOutput> filteredByStatus = new ArrayList<CompleteSpendingUnitRequestOutput>();
		
		for(CompleteSpendingUnitRequestOutput actRequest : listSpendingUnitRequestByUserId) {
			if(actRequest.getStatus().equals(status)){
				filteredByStatus.add(actRequest);
			}
		}
		
		return filteredByStatus;
	}
	
	//SpendingUnitRequests filtered by RequestStatus only
		public Iterable<CompleteSpendingUnitRequestOutput> getBySpendingUnitRequestStatus(String status){
			List <CompleteSpendingUnitRequestOutput> listSpendingUnitRequest = StreamSupport.stream(getAllWithoutDetailByOrder().spliterator(), false).collect(Collectors.toList());
			List <CompleteSpendingUnitRequestOutput> filteredByStatus = new ArrayList<CompleteSpendingUnitRequestOutput>();
			
			for(CompleteSpendingUnitRequestOutput actRequest : listSpendingUnitRequest) {
				if(actRequest.getStatus().equals(status)){
					filteredByStatus.add(actRequest);
				}
			}
			
			return filteredByStatus;
		}
	
	@Transactional
	public SpendingUnit save(SpendingUnit spendingUnit) {

		SpendingUnit unit= spendingUnitRepository.save(spendingUnit);
		unit.setAcronym("U"+idLastRegister());
		return unit;
	}
	
	private int idLastRegister() {
		List <SpendingUnit> allSpendingUnits = spendingUnitRepository.findAll();
		int idLast=0;
		for (SpendingUnit found: allSpendingUnits) {
			idLast=found.getIdSpendingUnit();
		}
		return idLast;
	}
	
	public Iterable<SpendingUnitOutput>  getAllSpendingUnitsByOrder(){
		List <SpendingUnit> allSpendingUnits = spendingUnitRepository.findAll();
		List <SpendingUnitOutput> allSpendingUnitsByOrder = new ArrayList<SpendingUnitOutput>();
		
		for (SpendingUnit found: allSpendingUnits) {
					
					SpendingUnitOutput newSpendingUnit = new SpendingUnitOutput();
					newSpendingUnit.setIdSpendingUnit(found.getIdSpendingUnit());
					newSpendingUnit.setNameUnit(found.getNameUnit());
					newSpendingUnit.setDescription(found.getDescription());
					newSpendingUnit.setResponsable(getResponsable(found));
					newSpendingUnit.setEmployees(foundResponsables(found));
					allSpendingUnitsByOrder.add(newSpendingUnit);
			
		}
		
		Collections.reverse(allSpendingUnitsByOrder);
		
		return allSpendingUnitsByOrder;	
	}
	private String getResponsable(SpendingUnit found) {
		List<UserRole> userRoles=found.getUserRole();
		String responsable=null;
		for(UserRole users: userRoles) {
			if(users.getUser().isSelected()==true) {
			   responsable=users.getUser().getName();   
			}
		}
		return responsable;
	}
	
	private List<UserOutputAtributes> foundResponsables(SpendingUnit found){
		List<UserRole> userRoles=found.getUserRole();
		List<UserOutputAtributes> responsables=new ArrayList<UserOutputAtributes>();
		
		for(UserRole users: userRoles) {
			UserOutputAtributes employees=new UserOutputAtributes();
			employees.setIdUser(users.getUser().getIdUser());
			employees.setName(users.getUser().getName());
			responsables.add(employees);
		}
		return responsables;
	}
}
