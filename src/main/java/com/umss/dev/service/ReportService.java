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
	
	private PriceQuotationRepository priceQuotationRepository;	
	


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
		//PriceQuotation priceQuotation=priceQuotationRepository.findById(reportRepository.idQuotation(id)).get();
		//System.out.println(reportRepository.idQuotation(id));
		Report report=reportRepository.findById(reportRepository.idReport(id)).get();
		getAtributesDocument(reportOutput, documentQuotationAtributesOutput, report);
		//getAtributesQuotaion(priceQuotation, reportOutput);
		PriceQuotationRequest priceQuotations=priceQuotationRequestService.gitById(report.getPriceQuotation().getIdPriceQuotationRequest());
		PriceQuotation priceQuotation=getPriceQuotaion(report.getPriceQuotation().getIdPriceQuotationRequest());
		
		System.out.println(documentQuotationAtributesOutput.getNameDocumenQuotaion());
		return reportOutput;
	}
	
	private PriceQuotation getPriceQuotaion(int id) {
		Iterable<PriceQuotationOutput> list=priceQuotationRequestService.getPriceQuotation(id);
		
		return null;
	}




	private void getAtributesDocument(ReportOutput reportOutput,DocumentQuotationAtributesOutput documentQuotationAtributesOutput,Report report) {
		documentQuotationAtributesOutput.setContent(report.getDocumentQuotation().getContent());
		documentQuotationAtributesOutput.setNameDocumenQuotaion(report.getDocumentQuotation().getNameDocumenQuotaion());
		documentQuotationAtributesOutput.setSizeDocuemntQuotaion(report.getDocumentQuotation().getSizeDocuemntQuotaion());
		
		reportOutput.setDescripcion(report.getCommentary());
		reportOutput.setDocumentQuotationAtributesOutput(documentQuotationAtributesOutput);
		
	}

	private void getAtributesQuotaion(PriceQuotation priceQuotation,ReportOutput reportOutput) {
		
		reportOutput.setTotal(priceQuotation.getTotal());
		reportOutput.setNameBusiness(priceQuotation.getBusiness().getName());
		reportOutput.setNameArea(priceQuotation.getBusiness().getArea().getName());
		
	}
}
