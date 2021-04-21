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
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
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
		
		for (SpendingUnitRequest req: allSpendingUnitRequests) {
			if (!req.getUserRole().getRole().equals(null)) {
				if(!req.getUserRole().getSpendingUnitRequest().isEmpty() || !req.getUserRole().getSpendingUnitRequest().equals(null)) {
					/*private int idSpendingUnitRequest;
						private String name;
						private Date date;
						private String status;
						private String type;
						private double estimatedAmount;
						private String justification;
						//private List<RequestDetail> requestDetail;
						private int userId;
						private String username;
						private int roleId;
						private String roleName;*/
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
	
	
	
}
