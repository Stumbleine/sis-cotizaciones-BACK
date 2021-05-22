package com.umss.dev.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

	@Query(value ="	SELECT q.id_price_quotation \r\n"
			+ "	FROM spending_unit_request s, price_quotaton_request p ,price_quotation q\r\n"
			+ "	WHERE s.id_spending_unit_request=:idSpendingUnitRequest\r\n"
			+ "	AND q.selected=1 \r\n"
			+ "	AND s.id_spending_unit_request=p.id_spending_unit_request \r\n"
			+ "	AND p.id_price_quotation_request=q.id_price_quotation_request",nativeQuery = true)
	int idQuotation(@Param("idSpendingUnitRequest")int idSpendingUnitRequest);

	@Query(value = "	SELECT r.id_report\r\n"
			+ "	FROM spending_unit_request s, price_quotaton_request p ,report r\r\n"
			+ "	WHERE s.id_spending_unit_request=:id \r\n"
			+ "	AND s.id_spending_unit_request=p.id_spending_unit_request \r\n"
			+ "	AND p.id_price_quotation_request= r.id_price_quotation_request",nativeQuery = true )
	int idReport(@Param("id")int id);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE report r SET r.id_price_quotation_request=:idPriceQuotationRequest WHERE r.id_report=:idReport",nativeQuery = true)
	void updateSpendingRequest(@Param("idPriceQuotationRequest")int idPriceQuotationRequest,@Param("idReport")int  idReport);
	
}
