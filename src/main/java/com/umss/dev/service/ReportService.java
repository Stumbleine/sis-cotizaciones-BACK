package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.entity.Report;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.output.ReportOutput;
import com.umss.dev.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private PriceQuotationRequestService priceQuotationRequestService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	public ReportService(ReportRepository reportRepository, PriceQuotationRequestService priceQuotationRequestService,
			ModelMapper modelMapper) {
		this.reportRepository = reportRepository;
		this.priceQuotationRequestService = priceQuotationRequestService;
		this.modelMapper = modelMapper;
	}
	
}
