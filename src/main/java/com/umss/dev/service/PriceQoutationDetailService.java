package com.umss.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.repository.PriceQoutationDetailRepository;

@Service
public class PriceQoutationDetailService {
	
	@Autowired
	private PriceQoutationDetailRepository priceQoutationDetailRepository;

}
