package com.umss.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.repository.SpendingUnitRequestRepository;

@Service
public class SpendingUnitRequestService {
	
	@Autowired
	private SpendingUnitRequestRepository spendingUnitRequestRepository;
	
	@Transactional
	public SpendingUnitRequest save(SpendingUnitRequest spendingUnitRequest) {
		return spendingUnitRequestRepository.save(spendingUnitRequest);
	}
}

