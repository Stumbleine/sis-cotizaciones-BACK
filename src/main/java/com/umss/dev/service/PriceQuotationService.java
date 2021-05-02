package com.umss.dev.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.PriceQuotation;
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
	
	public PriceQuotation save(PriceQuotation priceQuotation) {
		
		return priceQuotationRepository.save(priceQuotation);
	}

	public CompletePriceQuotationOutput getPriceQuotation(Integer idPriceQuotation) {
		PriceQuotation priceQuotation=priceQuotationRepository.findById(idPriceQuotation).get();
		CompletePriceQuotationOutput completePriceQuotationOutput = new CompletePriceQuotationOutput();
		completePriceQuotationOutput.setIdPriceQuotation(priceQuotation.getIdPriceQuotation());
		//datos de la empresa
		
		return completePriceQuotationOutput;
	}
	
	
}
