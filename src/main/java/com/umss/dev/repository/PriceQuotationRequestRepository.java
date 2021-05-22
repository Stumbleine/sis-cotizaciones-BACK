package com.umss.dev.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.PriceQuotationRequest;
	
	@Repository
	public interface PriceQuotationRequestRepository extends JpaRepository<PriceQuotationRequest, Integer>{
			

		@Modifying
		@Transactional
		@Query(value = "UPDATE price_quotation r set r.state=:state where CURDATE()>:deadline and r.id_price_quotation_request=:idPriceQuotationRequest and r.state=:vacio",nativeQuery = true)
		void update(@Param("state") String state,@Param("deadline")String deadline,@Param("idPriceQuotationRequest")int idPriceQuotationRequest,@Param("vacio")String vacio);

		@Modifying
		@Transactional
		@Query(value ="UPDATE spending_unit_request p SET p.id_price_quotation_request=:idPriceQuotationRequest WHERE p.id_spending_unit_request=:idSpendingRequest",nativeQuery = true)
		void updateSpendingRequest(@Param("idPriceQuotationRequest")int idPriceQuotationRequest,@Param("idSpendingRequest")int  idSpendingRequest);
	}


