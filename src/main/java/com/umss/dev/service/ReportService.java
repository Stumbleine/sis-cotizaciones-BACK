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


	public ReportOutput getReport(Integer id) {
		
		ReportOutput report= new ReportOutput();
		List<Report> listReport= reportRepository.findAll();
		Iterable<PriceQuotationOutput> quotations = new ArrayList<PriceQuotationOutput>();
		
		for(Report reports: listReport) {
		
			if(reports.getPriceQuotation().getIdPriceQuotationRequest()==id) {
	
				quotations= priceQuotationRequestService.getPriceQuotation(id);
				for(PriceQuotationOutput allQuotation: quotations) {
					System.out.println("TRUE OR FALSE: "+ allQuotation.getSelected());
					if(allQuotation.getSelected().booleanValue()== true) {
						report.setNameBusiness(allQuotation.getNameBussiness());
						report.setAreaBusiness(allQuotation.getNameArea());
						report.setCommentary(reports.getCommentary());
						report.setTotalQuotation(allQuotation.getTotal());
					}
				}
			}
			
			
		}
		return report;
	}
	
}
