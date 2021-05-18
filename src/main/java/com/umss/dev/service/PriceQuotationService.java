package com.umss.dev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Business;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.input.PriceQuotationInput;
import com.umss.dev.output.PriceQuotationIdOutput;
import com.umss.dev.output.BusinessOutput;
import com.umss.dev.output.CompletePriceQuotation;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.repository.PriceQuotationRepository;

@Service
public class PriceQuotationService {

	@Autowired
	private PriceQuotationRepository priceQuotationRepository;
	private ModelMapper modelMapper;
	private BusinessService businessService;
	private SpendingUnitRequestService spedingUnitRequestService;
	
	public PriceQuotationService(PriceQuotationRepository priceQuotationRepository, ModelMapper modelMapper, BusinessService businessService, SpendingUnitRequestService spedingUnitRequestService) {
		super();
		this.priceQuotationRepository = priceQuotationRepository;
		this.businessService = businessService;
		this.spedingUnitRequestService = spedingUnitRequestService;
		this.modelMapper = modelMapper;
	
	}
	
	public CompletePriceQuotation findPriceQuotationById(Integer priceQuotationId) {
		CompletePriceQuotation mapQuotation = new CompletePriceQuotation();
		PriceQuotation actPriceQuotation = priceQuotationRepository.findById(priceQuotationId).orElse(null);
		if (null == actPriceQuotation) {
			throw new DtoNotFoundException(PriceQuotation.class.toString(), priceQuotationId);
		}
		
		//CompletePriceQuotation mapQuotation = new CompletePriceQuotation();
		mapQuotation.setIdPriceQuotation(actPriceQuotation.getIdPriceQuotation());;
		mapQuotation.setState(actPriceQuotation.getState());
		mapQuotation.setTotal(actPriceQuotation.getTotal());
		mapQuotation.setWayOfPayment(actPriceQuotation.getWayOfPayment());
		mapQuotation.setGarantyTerm(actPriceQuotation.getGarantyTerm());
		mapQuotation.setOffValidation(actPriceQuotation.getOffValidation());
		mapQuotation.setSelected(actPriceQuotation.getSelected());
		mapQuotation.setPriceQuotationDetail(actPriceQuotation.getPriceQuotationDetail());
		mapQuotation.setCommentary(actPriceQuotation.getCommentary());
		mapQuotation.setDeliveryTerm(actPriceQuotation.getDeliveryTerm());
		//mapQuotation.setPriceQuotationRequest(actPriceQuotation.getPriceQuotationRequest());
		
		BusinessOutput businessOutput = new BusinessOutput();
		businessOutput.setIdBusiness(actPriceQuotation.getBusiness().getIdBusiness());
		businessOutput.setName(actPriceQuotation.getBusiness().getName());
		businessOutput.setAdress(actPriceQuotation.getBusiness().getAdress());
		businessOutput.setPhone(actPriceQuotation.getBusiness().getPhone());
		businessOutput.seteMail(actPriceQuotation.getBusiness().geteMail());
		businessOutput.setNit(actPriceQuotation.getBusiness().getNit());
		
		
		System.out.println("************************************************************************************");
		businessOutput.setIdArea(actPriceQuotation.getBusiness().getArea().getIdArea());
		businessOutput.setNameArea(actPriceQuotation.getBusiness().getArea().getName());
		
		mapQuotation.setBusiness(businessOutput);
		return mapQuotation;
		//information de la empresa
	}
	
	public PriceQuotation save(PriceQuotation priceQuotation) {
		return priceQuotationRepository.save(priceQuotation);
	}
	
	public PriceQuotation save2(PriceQuotationInput priceQuotationInput, int idSpendingUnitRequest) {
		PriceQuotation actPriceQuotation = new PriceQuotation();
		actPriceQuotation.setWayOfPayment(priceQuotationInput.getWayOfPayment());
		actPriceQuotation.setGarantyTerm(priceQuotationInput.getGarantyTerm());
		actPriceQuotation.setDeliveryTerm(priceQuotationInput.getDeliveryTerm());
		actPriceQuotation.setOffValidation(priceQuotationInput.getOffValidation());
		actPriceQuotation.setTotal(priceQuotationInput.getTotal());
		actPriceQuotation.setCommentary(priceQuotationInput.getCommentary());
		actPriceQuotation.setState(priceQuotationInput.getState());
		actPriceQuotation.setPriceQuotationDetail(priceQuotationInput.getPriceQuotationDetail());
		
		System.out.println("**************************** business ////"+priceQuotationInput.getIdBusiness());
		Integer id = new Integer(priceQuotationInput.getIdBusiness());
		
		if(!(id.equals(null)|| priceQuotationInput.getIdBusiness()== 0)) {
			
			Business actBusiness = businessService.getByIdBusiness(priceQuotationInput.getIdBusiness());
			//Optional<Business> actBusiness = businessRepository.findById(id);
			System.out.println("**********************************");
			//System.out.println(actBusiness.toString());
			actPriceQuotation.setBusiness(actBusiness);

			
		}
				
		System.out.println("****************************spendinUnitRequest////"+idSpendingUnitRequest);
		SpendingUnitRequest request = spedingUnitRequestService.getSpendingUnitRequestNormal(idSpendingUnitRequest);
		actPriceQuotation.setPriceQuotationRequest(request.getPriceQuotation());
		
		return priceQuotationRepository.save(actPriceQuotation);
		
		
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
	
	public Iterable<PriceQuotationOutput> getPriceQuotationByOrder(Integer idPriceQuotationRequest){

		List <PriceQuotation> allPriceQuotation = priceQuotationRepository.findAll();
		List <PriceQuotationOutput> pricequotations = new ArrayList<PriceQuotationOutput>();
		List<Integer> reqIds = new ArrayList<Integer>();
		List <PriceQuotationOutput> allPriceQuotationByOrder = new ArrayList<PriceQuotationOutput>();

			for (PriceQuotation req: allPriceQuotation) {
				if(idPriceQuotationRequest == req.getPriceQuotationRequest().getIdPriceQuotationRequest()) {
		        PriceQuotationOutput newReq = new PriceQuotationOutput();
				newReq.setIdPriceQuotation(req.getIdPriceQuotation());					
				reqIds.add(req.getIdPriceQuotation());					
				newReq.setState(req.getState());
				newReq.setNameBussiness(req.getBusiness().getName());
				newReq.setNameArea(req.getBusiness().getArea().getName());
				newReq.setTotal(req.getTotal());
				newReq.setPriceQuotationDetail(req.getPriceQuotationDetail());
				newReq.setDeadline(req.getPriceQuotationRequest().getDeadline());
				pricequotations.add(newReq);
				
				}
	         }
		Collections.sort(reqIds);
		Collections.reverse(reqIds);
		
		for(Integer actId: reqIds) {
			for(PriceQuotationOutput actReq: pricequotations) {
				if(actId == actReq.getIdPriceQuotation()) {
					
					allPriceQuotationByOrder.add(actReq);
				}
				
			}
			
		}
		
		return allPriceQuotationByOrder;	
	}
	
}
