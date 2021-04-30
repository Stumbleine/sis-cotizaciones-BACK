package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.PriceQuotation;

@Repository
public interface PriceQuotationRepository extends JpaRepository<PriceQuotation, Integer>{

}
