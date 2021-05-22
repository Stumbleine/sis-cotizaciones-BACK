package com.umss.dev.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.DocumentQuotation;

@Repository
public interface DocumentQuotationRepository  extends JpaRepository<DocumentQuotation, Integer>{

	
	@Modifying
	@Transactional
	@Query(value ="UPDATE document_quotation r SET r.id_report=:idReport WHERE r.id_document_quotaion=:idDocument",nativeQuery = true)
	void updateDocument(@Param("idReport")int idReport,@Param("idDocument")int  idDocument);
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE report r SET r.id_file=:idDocument WHERE r.id_report=:idReport",nativeQuery = true)
	void upDateReport(@Param("idReport")int idReport,@Param("idDocument")int  idDocument);
}
