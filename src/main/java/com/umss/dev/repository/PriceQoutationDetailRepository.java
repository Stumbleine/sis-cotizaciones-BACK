package com.umss.dev.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.PriceQuotationDetail;

@Repository
public interface PriceQoutationDetailRepository extends JpaRepository<PriceQuotationDetail, Integer>{

	
	@Modifying
	@Transactional
	@Query(value ="UPDATE price_qoutation_detail d SET d.id_file=:idDocument WHERE d.id_price_quotation_detail=:idDetail",nativeQuery = true)
	void updateDocument(@Param("idDetail")int idDetail,@Param("idDocument")int  idDocument);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE price_qoutation_detail d SET d.state=:state WHERE d.id_price_quotation_detail=:idDetail",nativeQuery = true)
	void updateDetailExistence(@Param("idDetail")int idDetail,@Param("state")int state);
}
