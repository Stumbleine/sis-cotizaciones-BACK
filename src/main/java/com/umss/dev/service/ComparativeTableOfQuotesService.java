package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.ComparativeTableOfQuotes;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.repository.ComparativeTableOfQuotesRepository;
import com.umss.dev.repository.PriceQuotationRepository;
import com.umss.dev.repository.PriceQuotationRequestRepository;
import com.umss.dev.repository.SpendingUnitRequestRepository;

@Service
public class ComparativeTableOfQuotesService {
	
	@Autowired
	private ComparativeTableOfQuotesRepository comparativeTableOfQuotesRepository;
	private PriceQuotationRequestRepository priceQuotationRequestRepository;
	private PriceQuotationRepository priceQuotationRepository;
	private ModelMapper modelMapper;
	@Autowired
	private SpendingUnitRequestRepository spendingUnitRequestRepository;
	
	public ComparativeTableOfQuotesService(ComparativeTableOfQuotesRepository comparativeTableOfQuotesRepository, ModelMapper modelMapper, PriceQuotationRequestRepository priceQuotationRequestRepository, PriceQuotationRepository priceQuotationRepository) {
		this.comparativeTableOfQuotesRepository = comparativeTableOfQuotesRepository;
		this.modelMapper = modelMapper;
		this.priceQuotationRequestRepository= priceQuotationRequestRepository;
		this.priceQuotationRepository =priceQuotationRepository;
	}


	@Transactional
	public ComparativeTableOfQuotes save(ComparativeTableOfQuotes comparativeTableOfQuotes,Integer id) {
		Optional<SpendingUnitRequest> srequest= spendingUnitRequestRepository.findById(id);
		Optional<PriceQuotationRequest> request= priceQuotationRequestRepository.findById(srequest.get().getPriceQuotation().getIdPriceQuotationRequest());
		comparativeTableOfQuotes.setPriceQuotationRequest(request.get());
		return comparativeTableOfQuotesRepository.save(comparativeTableOfQuotes);
	}
	
	public Iterable<ComparativeTableOfQuotes> getComparativeTable(Integer id){
		
		List <ComparativeTableOfQuotes> allComparativeTableOfQuotes = comparativeTableOfQuotesRepository.findAll();
		List <ComparativeTableOfQuotes> comparativeTableOfQuotes = new ArrayList<ComparativeTableOfQuotes>();
		for(ComparativeTableOfQuotes allTable :allComparativeTableOfQuotes) {
			if(allTable.getPriceQuotationRequest().getSpendingUnitRequest().getIdSpendingUnitRequest()==id) {
				comparativeTableOfQuotes.add(allTable);
			}
		}
		return comparativeTableOfQuotes;
	}
	
	/*public ComparativeTableOfQuotes update(Integer id, ComparativeTableOfQuotes comparativeTableOfQuotes) {
		Optional<SpendingUnitRequest> srequest= spendingUnitRequestRepository.findById(id);
		Optional<PriceQuotationRequest> request= priceQuotationRequestRepository.findById(srequest.get().getPriceQuotation().getIdPriceQuotationRequest());
		comparativeTableOfQuotes.setPriceQuotationRequest(request.get());
		return comparativeTableOfQuotesRepository.save(comparativeTableOfQuotes);
	}*/

	  
}
