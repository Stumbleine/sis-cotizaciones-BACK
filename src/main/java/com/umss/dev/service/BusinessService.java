package com.umss.dev.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.repository.BusinessRepository;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;
	private ModelMapper modelMapper;
	
	public BusinessService(BusinessRepository businessRepository, ModelMapper modelMapper) {
		super();
		this.businessRepository = businessRepository;
		this.modelMapper = modelMapper;
	}
	
	
	
}
