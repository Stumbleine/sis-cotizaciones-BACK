package com.umss.dev.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.output.PriceQuotationRequestOutput;
import com.umss.dev.output.SpendingUnitRequesteOutputAtributes;
import com.umss.dev.repository.PriceQuotationRequestRepository;
import com.umss.dev.repository.SpendingUnitRequestRepository;

@Service
public class PriceQuotationRequestService {
	
	private PriceQuotationRequestRepository priceQuotationRequestRepository;
	private ModelMapper modelMapper;
	private PriceQuotationService priceQuotationService;
	@Autowired
	private SpendingUnitRequestRepository spendingUnitRequestRepository;
	
	public PriceQuotationRequestService(PriceQuotationRequestRepository priceQuotationRequestRepository,ModelMapper modelMapper, PriceQuotationService priceQuotationService) {
		this.priceQuotationRequestRepository = priceQuotationRequestRepository;
		this.modelMapper = modelMapper;
		this.priceQuotationService =priceQuotationService;
	}
	
	public Iterable<PriceQuotationOutput> getPriceQuotation(Integer idPriceQuotation){
		Optional<SpendingUnitRequest> srequest= spendingUnitRequestRepository.findById(idPriceQuotation);
		Optional<PriceQuotationRequest> request= priceQuotationRequestRepository.findById(srequest.get().getPriceQuotation().getIdPriceQuotationRequest());
		return priceQuotationService.getPriceQuotationByOrder(request.get().getIdPriceQuotationRequest());
	}
	
	public PriceQuotationRequestOutput save(Integer id,PriceQuotationRequest request) {
		
		Optional<SpendingUnitRequest> srequest= spendingUnitRequestRepository.findById(id);
		Optional<PriceQuotationRequest> priceRequest= priceQuotationRequestRepository.findById(srequest.get().getPriceQuotation().getIdPriceQuotationRequest());
		priceRequest.get().setDeadline(request.getDeadline());
		priceQuotationRequestRepository.save(priceRequest.get());
		PriceQuotationRequestOutput priceQuotationRequest=new PriceQuotationRequestOutput();
		priceQuotationRequest.setIdPriceQuotationRequest(priceRequest.get().getIdPriceQuotationRequest());
		priceQuotationRequest.setDeadline(priceRequest.get().getDeadline());
		return priceQuotationRequest;
	}

	/*public Student getById(Integer studentId) {
		Student studentAct = studentRepository.findById(studentId).orElse(null);
	    if (null == studentAct) {
	        throw new DtoNotFoundException(StudentResponse.class.toString(), studentId);
	    }
	    //StudentResponse foundStudent = modelMapper.map(studentAct, StudentResponse.class);
	    //foundStudent.setStudentId(studentAct.getStudentId());
	    return studentAct;
	}*/
	
	public PriceQuotationRequest getPriceQuotationRequestById (int id) {
		PriceQuotationRequest actRequest = priceQuotationRequestRepository.findById(id).orElse(null);
		if(null == actRequest) {
			throw new DtoNotFoundException(PriceQuotationRequest.class.toString(),id);
		}
		return actRequest;
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
	
	public PriceQuotationRequest gitById(int id) {
		return priceQuotationRequestRepository.findById(id).get();
	}

}
