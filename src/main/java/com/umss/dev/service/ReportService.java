	package com.umss.dev.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.entity.Report;
import com.umss.dev.output.CompletePriceQuotation;
import com.umss.dev.output.DocumentQuotationAtributesOutput;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.output.ReportOutput;
import com.umss.dev.repository.PriceQuotationRepository;
import com.umss.dev.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private PriceQuotationRequestService priceQuotationRequestService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PriceQuotationService priceQuotationService;
	
	public ReportService(ReportRepository reportRepository, PriceQuotationRequestService priceQuotationRequestService,
			ModelMapper modelMapper, PriceQuotationService priceQuotationService) {
		super();
		this.reportRepository = reportRepository;
		this.priceQuotationRequestService = priceQuotationRequestService;
		this.modelMapper = modelMapper;
		this.priceQuotationService = priceQuotationService;
	}

	public ReportOutput getReport(Integer id) {
		ReportOutput reportOutput=new ReportOutput();
		DocumentQuotationAtributesOutput documentQuotationAtributesOutput=new DocumentQuotationAtributesOutput();
		
		//System.out.println(priceQuotation.getBusiness().getName());
		try {
			CompletePriceQuotation priceQuotation=priceQuotationService.findPriceQuotationById(reportRepository.idQuotation(id));
			Report report=reportRepository.findById(reportRepository.idReport(id)).get();
			getAtributesDocument(reportOutput, documentQuotationAtributesOutput, report);
			getAtributesQuotaion(priceQuotation, reportOutput);
		} catch (Exception e) {
			reportOutput=null;
		}
		
		
		//System.out.println(documentQuotationAtributesOutput.getNameDocumenQuotaion());
		return reportOutput;
	}
	


	private void getAtributesDocument(ReportOutput reportOutput,DocumentQuotationAtributesOutput documentQuotationAtributesOutput,Report report) {
		documentQuotationAtributesOutput.setContent(report.getDocumentQuotation().getContent());
		documentQuotationAtributesOutput.setNameDocumenQuotaion(report.getDocumentQuotation().getNameDocumenQuotaion());
		documentQuotationAtributesOutput.setSizeDocuemntQuotaion(report.getDocumentQuotation().getSizeDocuemntQuotaion());
		
		reportOutput.setDescripcion(report.getCommentary());
		reportOutput.setDocumentQuotationAtributesOutput(documentQuotationAtributesOutput);
		
	}

	private void getAtributesQuotaion(CompletePriceQuotation priceQuotation,ReportOutput reportOutput) {
		
		reportOutput.setTotal(priceQuotation.getTotal());
		reportOutput.setNameBusiness(priceQuotation.getBusiness().getName());
		reportOutput.setNameArea(priceQuotation.getBusiness().getNameArea());;
		
	}
}
