package com.umss.dev.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.umss.dev.entity.DocumentQuotation;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationDetail;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.DocumentQuotationAtributesOutput;
import com.umss.dev.repository.DocumentQuotationRepository;
import com.umss.dev.repository.PriceQuotationRepository;

@Service
public class DocumetQuotationService {

	
	@Autowired
	private DocumentQuotationRepository documentQuotationRepository;
	@Autowired
	private PriceQuotationService priceQuotationService;
	@Autowired
	private SpendingUnitRequestService requestService;
	private ModelMapper mapper ;
	@Autowired
	private PriceQuotationRepository priceQuotationRepository;
	@Autowired
	private PriceQoutationDetailService detailService;
	


	public DocumetQuotationService(DocumentQuotationRepository documentQuotationRepository,
			PriceQuotationService priceQuotationService, SpendingUnitRequestService requestService,
			ModelMapper mapper) {
		super();
		this.documentQuotationRepository = documentQuotationRepository;
		this.priceQuotationService = priceQuotationService;
		this.requestService = requestService;
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



	public DocumentQuotation saveDocumentQuotation(MultipartFile file, Integer id) {
		DocumentQuotation documentQuotation= new DocumentQuotation();
		try {
			String nameFile=file.getOriginalFilename();
			documentQuotation.setNameDocumenQuotaion(nameFile);
			documentQuotation.setContent(file.getBytes());
			documentQuotation.setSizeDocuemntQuotaion(file.getSize());
			//documentQuotation.setPriceQuotation(null);
			documentQuotationRepository.save(documentQuotation);
			documentQuotationRepository.upDateDocumentPriceQuotation(id, documentQuotation.getIdDocumentQuotaion());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return documentQuotation;
		
	}

	public DocumentQuotationAtributesOutput getDocumneByIdPriceQuotation(Integer id) {
		
		List<DocumentQuotation> documentQuotations=documentQuotationRepository.documents(id);  		
		DocumentQuotationAtributesOutput quotationAtributesOutput= new DocumentQuotationAtributesOutput();
		if(!documentQuotations.isEmpty()) {
			
			//System.out.println("------------->" +documentQuotations.get(0).getNameDocumenQuotaion());
			quotationAtributesOutput.setContent(documentQuotations.get(0).getContent());
			quotationAtributesOutput.setNameDocumenQuotaion(documentQuotations.get(0).getNameDocumenQuotaion());
			quotationAtributesOutput.setSizeDocuemntQuotaion(documentQuotations.get(0).getSizeDocuemntQuotaion());

		}
		else {
			quotationAtributesOutput=null;
		}
		
		return quotationAtributesOutput;
	}

	public DocumentQuotationAtributesOutput getDocumneByIdReport(Integer id) {
		SpendingUnitRequest request= requestService.getSpendingUnitRequestNormal(id);
		
		if(request.getPriceQuotation()!=null) {
			DocumentQuotation documentQuotation=request.getPriceQuotation().getReport().getDocumentQuotation();		
			DocumentQuotationAtributesOutput documentQuotationAtributesOutput=new DocumentQuotationAtributesOutput();		
			documentQuotationAtributesOutput.setContent(documentQuotation.getContent());
			documentQuotationAtributesOutput.setNameDocumenQuotaion(documentQuotation.getNameDocumenQuotaion());
			documentQuotationAtributesOutput.setSizeDocuemntQuotaion(documentQuotation.getSizeDocuemntQuotaion());
			
			return documentQuotationAtributesOutput;
		}else {
			return null;
		}
		
	}

	public DocumentQuotationAtributesOutput getDocumneByIdQuotation(Integer id) {
		
		
		List<DocumentQuotation> list=documentQuotationRepository.documents(id);
		
		DocumentQuotationAtributesOutput documentQuotationAtributesOutput=new DocumentQuotationAtributesOutput();
		
		documentQuotationAtributesOutput.setContent(list.get(0).getContent());
		
		return documentQuotationAtributesOutput;
	}
	
	public DocumentQuotationAtributesOutput deleteDocumentByIdPriceQuotation(Integer id) {
		
		List<DocumentQuotation> documentQuotation=documentQuotationRepository.documents(id);  
		//Optional<PriceQuotation> priceQuotation = priceQuotationRepository.findById(id);
		System.out.println("------------->" +documentQuotation.get(0).getNameDocumenQuotaion());
		DocumentQuotationAtributesOutput documentQuotationOutput= new DocumentQuotationAtributesOutput();
		if(!documentQuotation.isEmpty()) {
			documentQuotation.get(0).setPriceQuotation(null);
			documentQuotationOutput.setContent(documentQuotation.get(0).getContent());
			documentQuotationOutput.setNameDocumenQuotaion(documentQuotation.get(0).getNameDocumenQuotaion());
			documentQuotationOutput.setSizeDocuemntQuotaion(documentQuotation.get(0).getSizeDocuemntQuotaion());
			documentQuotationRepository.delete(documentQuotation.get(0));
		}
		else {
			documentQuotationOutput=null;
		}
		
		return documentQuotationOutput;
	}


	public DocumentQuotation saveDocumentQuotationDetail(MultipartFile file,int idQuotationDetail) {
		DocumentQuotation documentQuotation= new DocumentQuotation();
		PriceQuotationDetail detail= detailService.getDetail(idQuotationDetail);
		try {
			String nameFile=file.getOriginalFilename();
			documentQuotation.setNameDocumenQuotaion(nameFile);
			documentQuotation.setContent(file.getBytes());
			documentQuotation.setSizeDocuemntQuotaion(file.getSize());
			documentQuotation.setPriceQuotationDetail(detail);
			documentQuotationRepository.save(documentQuotation);
			detailService.upDateDetailDocument(idQuotationDetail,documentQuotation.getIdDocumentQuotaion());
			detailService.upDateDetailExistence(idQuotationDetail,1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return documentQuotation;
	}
	
	public byte[] bobItemDocument(int idPriceQuotationDetail) {
		
		return documentQuotationRepository.itemDocuments(idPriceQuotationDetail).get(0).getContent();
	}
}
	