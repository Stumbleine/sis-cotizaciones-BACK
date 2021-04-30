package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.PriceQuotationDetail;

@Repository
public interface PriceQoutationDetailRepository extends JpaRepository<PriceQuotationDetail, Integer>{

}
