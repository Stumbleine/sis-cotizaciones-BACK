package com.umss.dev.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.DocumentQuotation;
import com.umss.dev.repository.DocumentQuotationRepository;

@Service
public class DocumetQuotationService {

	
	@Autowired
	private DocumentQuotationRepository documentQuotationRepository;
	
	private ModelMapper mapper ;

	public DocumetQuotationService(DocumentQuotationRepository documentQuotationRepository, ModelMapper mapper) {
		super();
		this.documentQuotationRepository = documentQuotationRepository;
		this.mapper = mapper;
	}
	
	public void saveDocumentQuotation(DocumentQuotation documentQuotation) {
		
		documentQuotationRepository.save(documentQuotation);
	}
}
	