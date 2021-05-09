package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.PriceQuotationRequest;
	
	@Repository
	public interface PriceQuotationRequestRepository extends JpaRepository<PriceQuotationRequest, Integer>{

	}


