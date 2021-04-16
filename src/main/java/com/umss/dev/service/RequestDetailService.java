package com.umss.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umss.dev.entity.RequestDetail;
import com.umss.dev.repository.RequestDetailRepository;


@Service
public class RequestDetailService {
	
	@Autowired
	private RequestDetailRepository requestDetailRepository;
}
