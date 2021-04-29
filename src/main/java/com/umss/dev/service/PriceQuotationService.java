package com.umss.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.repository.PriceQuotationRepository;

@Service
public class PriceQuotationService {

	@Autowired
	private PriceQuotationRepository priceQuotationRepository;
}
