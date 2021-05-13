package com.umss.dev.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.output.SpendingUnitRequesteOutputAtributes;
import com.umss.dev.repository.PriceQuotationRequestRepository;

@Service
public class PriceQuotationRequestService {
	
	private PriceQuotationRequestRepository priceQuotationRequestRepository;
	private ModelMapper modelMapper;
	private PriceQuotationService priceQuotationService;
	
	public PriceQuotationRequestService(PriceQuotationRequestRepository priceQuotationRequestRepository,ModelMapper modelMapper, PriceQuotationService priceQuotationService) {
		this.priceQuotationRequestRepository = priceQuotationRequestRepository;
		this.modelMapper = modelMapper;
		this.priceQuotationService =priceQuotationService;
	}
	
	public Iterable<PriceQuotationOutput> getPriceQuotation(Integer idPriceQuotation){
		
		Optional<PriceQuotationRequest> request= priceQuotationRequestRepository.findById(idPriceQuotation);
		return priceQuotationService.getPriceQuotationByOrder(request.get().getIdPriceQuotationRequest());
	}

						//S/M/H/D/M
	//@Scheduled(cron = "0 * * * * ?")
	@Scheduled(cron = "0 0 0 * * ?")
	   public void cronJobSch() {
		
		List<PriceQuotationRequest>priceQuotationRequests=priceQuotationRequestRepository.findAll();
	    
	      if(!priceQuotationRequests.isEmpty()) {
	    	  for(int i=0;i<priceQuotationRequests.size();i++) {
	    		 if(priceQuotationRequests.get(i).getDeadline()!=null) {
	    			 priceQuotationRequestRepository.update("EXPIRADO",priceQuotationRequests.get(i).getDeadline().toString() ,priceQuotationRequests.get(i).getIdPriceQuotationRequest(), "SIN COTIZAR");
	    		 }    		  
	    	  }
	    	 
	      }
	       
	   }

}
