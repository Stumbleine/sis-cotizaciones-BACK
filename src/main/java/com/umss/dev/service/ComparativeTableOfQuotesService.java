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

@Service
public class ComparativeTableOfQuotesService {
	
	@Autowired
	private ComparativeTableOfQuotesRepository comparativeTableOfQuotesRepository;
	private PriceQuotationRequestRepository priceQuotationRequestRepository;
	private PriceQuotationRepository priceQuotationRepository;
	private ModelMapper modelMapper;
	
	
	public ComparativeTableOfQuotesService(ComparativeTableOfQuotesRepository comparativeTableOfQuotesRepository, ModelMapper modelMapper, PriceQuotationRequestRepository priceQuotationRequestRepository, PriceQuotationRepository priceQuotationRepository) {
		this.comparativeTableOfQuotesRepository = comparativeTableOfQuotesRepository;
		this.modelMapper = modelMapper;
		this.priceQuotationRequestRepository= priceQuotationRequestRepository;
		this.priceQuotationRepository =priceQuotationRepository;
	}


	@Transactional
	public ComparativeTableOfQuotes save(ComparativeTableOfQuotes comparativeTableOfQuotes,Integer id) {
		Optional<PriceQuotationRequest> request= priceQuotationRequestRepository.findById(id);
		comparativeTableOfQuotes.setPriceQuotationRequest(request.get());
		return comparativeTableOfQuotesRepository.save(comparativeTableOfQuotes);
	}
	
   /* public Iterable<ComparativeTableOfQuotes> savePost(Integer idPriceQuotation, List<Integer> Ids){
    	System.out.println("LLega aqui 222");
		Optional<PriceQuotationRequest> request= priceQuotationRequestRepository.findById(idPriceQuotation);
		
		List <PriceQuotationOutput> allQ= new ArrayList<PriceQuotationOutput>();
		List <PriceQuotation> allQuotations= new ArrayList<PriceQuotation>();
		Optional<PriceQuotation> quotation;
		Optional<PriceQuotation> quotation1;
		quotation = priceQuotationRepository.findById(Ids.get(0)); //los ids existen
		System.out.println("LLega aqui 333");
		
		if (quotation.get().getPriceQuotationRequest().getIdPriceQuotationRequest() == request.get()
				.getIdPriceQuotationRequest()) {

			for (int i = 0; i < quotation.get().getPriceQuotationDetail().size(); i++) {

				System.out.println("LLega aqui");
				ComparativeTableOfQuotes newComparative = new ComparativeTableOfQuotes();
				newComparative.setUnit(quotation.get().getPriceQuotationDetail().get(i).getUnit());
				newComparative.setQuantity(quotation.get().getPriceQuotationDetail().get(i).getQuantity());
				newComparative.setDescription(quotation.get().getPriceQuotationDetail().get(i).getDescription());

				for (Integer idQ : Ids) {

					quotation1 = priceQuotationRepository.findById(idQ);
					if (idQ == quotation.get().getIdPriceQuotation() && request.get().getIdPriceQuotationRequest() == quotation.get().getPriceQuotationRequest().getIdPriceQuotationRequest()) {
						newComparative.setSubtotalBussiness1(quotation.get().getPriceQuotationDetail().get(i).getTotalPrice());
					}
				}
			}
		}
		return allQ;
	}*/

    //getPriceQuotation
    /*public Iterable<ComparativeTableOfQuotes> getComparativeTableOfQuotes(List <PriceQuotation> quotations, PriceQuotationRequest request){
    	List <ComparativeTableOfQuotes> allQuotations= new ArrayList<ComparativeTableOfQuotes>();
    	for (PriceQuotation req: quotations) {
    		        ComparativeTableOfQuotes quotation = new ComparativeTableOfQuotes();
					quotation.setQuantity(request.getSpendingUnitRequest().getRequestDetail().get(0).getQuantity());
					quotation.setUnit(request.getSpendingUnitRequest().getRequestDetail().get(0).getUnit());
					quotation.setDescription(null);
					allSpendingUnitReqWithoutDetail.add(newReq);
			
		}
    }*/
	
	public Iterable<ComparativeTableOfQuotes> getAll(){
		List <ComparativeTableOfQuotes> allComparativeTableOfQuotes = comparativeTableOfQuotesRepository.findAll();
		return allComparativeTableOfQuotes;
	}

}
