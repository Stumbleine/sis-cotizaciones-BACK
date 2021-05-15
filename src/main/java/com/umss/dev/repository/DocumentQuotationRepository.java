package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.DocumentQuotation;

@Repository
public interface DocumentQuotationRepository  extends JpaRepository<DocumentQuotation, Integer>{

}
