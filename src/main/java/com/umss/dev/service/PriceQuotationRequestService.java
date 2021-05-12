package com.umss.dev.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.repository.PriceQuoatitonRequestRepository;
import com.umss.dev.repository.PriceQuotationRepository;

@Service
@Component
public class PriceQuotationRequestService {
	
	@Autowired
	private PriceQuoatitonRequestRepository priceQuoatitonRequestRepository;
	@Autowired
	private PriceQuotationRepository priceQuotationRepository;
	private ModelMapper modelMapper;
	
	

	public PriceQuotationRequestService(PriceQuoatitonRequestRepository priceQuoatitonRequestRepository,
			PriceQuotationRepository priceQuotationRepository, ModelMapper modelMapper) {
		super();
		this.priceQuoatitonRequestRepository = priceQuoatitonRequestRepository;
		this.priceQuotationRepository = priceQuotationRepository;
		this.modelMapper = modelMapper;
	}



	@Scheduled(cron = "0 0 0 * * ?")
	   public void cronJobSch() {
		
		List<PriceQuotationRequest>priceQuotationRequests=priceQuoatitonRequestRepository.findAll();
	    
	      if(!priceQuotationRequests.isEmpty()) {
	    	  for(int i=0;i<priceQuotationRequests.size();i++) {
	    		 if(priceQuotationRequests.get(i).getDeadline()!=null) {
	    			 priceQuoatitonRequestRepository.update("EXPIRADO",priceQuotationRequests.get(i).getDeadline().toString() ,priceQuotationRequests.get(i).getIdPriceQuotationRequest(), "VACIO");
	    		 }    		  
	    	  }
	    	 
	      }
	       
	   }

/*

	private void setStatusDeadLine(PriceQuotationRequest priQuotationRequest) {
		List<PriceQuotation> priceQuotations=priceQuotationRepository.findAll();
		List<PriceQuotation> reponse=new ArrayList<PriceQuotation>();
		PriceQuotation newPriceQuotation = new PriceQuotation();
		for(int i=0;i<priceQuotations.size();i++) {
			if(priceQuotations.get(i).getPriceQuotationRequest().getIdPriceQuotationRequest()== priQuotationRequest.getIdPriceQuotationRequest()) {
				if(priceQuotations.get(i).getState().compareTo("VACIO")==0) {
					
					//System.out.println(newPriceQuotation.getIdPriceQuotation()+"------>  "+ newPriceQuotation.getState());
				}
			}
		}
		/*
		if(priceQuotations.isEmpty()) {
			for(int i=0;i<priceQuotations.size();i++) {
				if(priceQuotations.get(i).getState()=="VACIO") {
					
					System.out.println("asdfasdfasd");
				}
				
			}
		}
	}*/
}
