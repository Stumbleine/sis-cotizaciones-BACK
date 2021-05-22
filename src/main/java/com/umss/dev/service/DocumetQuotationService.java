package com.umss.dev.service;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	
	
	public DocumentQuotation getById(int id) {
		
		return documentQuotationRepository.findById(id).get();
	}

	public DocumentQuotation saveDocumentQuotation(MultipartFile file) {
		DocumentQuotation documentQuotation= new DocumentQuotation();
		try {
			String nameFile=file.getOriginalFilename();
			documentQuotation.setNameDocumenQuotaion(nameFile);
			documentQuotation.setContent(file.getBytes());
			documentQuotation.setSizeDocuemntQuotaion(file.getSize());
			
			documentQuotationRepository.save(documentQuotation);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return documentQuotation;
	}
	
	public void saveDocumentReport(DocumentQuotation documentQuotation) {
		documentQuotationRepository.save(documentQuotation);
	}

	public void createDocument(MultipartFile file, int idReport) throws IOException {
		
		DocumentQuotation documentQuotation = new DocumentQuotation(file.getOriginalFilename(), file.getSize(), file.getBytes(),null);
		documentQuotationRepository.save(documentQuotation);
		documentQuotationRepository.updateDocument(idReport, documentQuotation.getIdDocumentQuotaion());
		documentQuotationRepository.upDateReport(idReport, documentQuotation.getIdDocumentQuotaion());
	}
}
	