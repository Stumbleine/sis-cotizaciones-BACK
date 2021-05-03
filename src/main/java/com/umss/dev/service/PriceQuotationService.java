package com.umss.dev.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.output.CompletePriceQuotationOutput;
import com.umss.dev.repository.PriceQuotationRepository;

@Service
public class PriceQuotationService {

	@Autowired
	private PriceQuotationRepository priceQuotationRepository;

	private ModelMapper modelMapper;
	
	public PriceQuotationService(PriceQuotationRepository priceQuotationRepository, ModelMapper modelMapper) {
		super();
		this.priceQuotationRepository = priceQuotationRepository;
		this.modelMapper = modelMapper;
	
	}
	
	/*public PriceQuotation findById(Integer priceQuotationId) {
		PriceQuotation actPriceQuotation = priceQuotationRepository.findById(priceQuotationId).orElse(null);
		if (null == actPriceQuotation) {
			throw new DtoNotFoundException(PriceQuotation.class.toString(), priceQuotationId);
		}
		return actPriceQuotation;
		//information de la empresa
	}*/
	
	/*public ComentarioResponse save2(PriceQuotation priceQuotation) {//post//create
		System.out.println(priceQuotation.toString());
	
	 priceQuotation converted = modelMapper.map(priceQuotation,PriceQuotation.class);
	 
	 System.out.println(converted.toString());
	 
     Comentario persistedUser = comentarioRepository.save(converted);
    
     ComentarioResponse comentarioResponse = modelMapper.map(persistedUser, ComentarioResponse.class);
   
     return comentarioResponse;
	}*/
	
	public PriceQuotation save(PriceQuotation priceQuotation) {
		return priceQuotationRepository.save(priceQuotation);
	}
	
	//Alison
	@Transactional
	public PriceQuotation saveOther(PriceQuotation priceQuotation) {
		return priceQuotationRepository.save(priceQuotation);
	}

	/*public CompletePriceQuotationOutput getPriceQuotation(Integer idPriceQuotation) {
		PriceQuotation priceQuotation=priceQuotationRepository.findById(idPriceQuotation).get();
		CompletePriceQuotationOutput completePriceQuotationOutput = new CompletePriceQuotationOutput();
		completePriceQuotationOutput.setIdPriceQuotation(priceQuotation.getIdPriceQuotation());
		//datos de la empresa
		
		return completePriceQuotationOutput;
	}*/
	
	
	
}
