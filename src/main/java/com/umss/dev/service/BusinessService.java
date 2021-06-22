package com.umss.dev.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.input.CreateBusinessInput;
import com.umss.dev.entity.Area;
import com.umss.dev.entity.Business;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.repository.BusinessRepository;
import com.umss.dev.repository.PriceQuotationRepository;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;
	private ModelMapper modelMapper;
	@Autowired
	private AreaService areaService;
	@Autowired
	private PriceQuotationRepository priceQuotationRepository;
	
	public BusinessService(BusinessRepository businessRepository, ModelMapper modelMapper) {
		super();
		this.businessRepository = businessRepository;
		this.modelMapper = modelMapper;
	}
	/*//Alison
	@Transactional
	public PriceQuotation saveOther(PriceQuotation priceQuotation) {
		return priceQuotationRepository.save(priceQuotation);
	}*/
	
	@Transactional
	public Business save(Business business) {
		return businessRepository.save(business);
	}
	
	public Business getLastBusiness() {
		List<Business> list = businessRepository.findAll();
		System.out.println("///************** id of last Business: "+ list.size());
		return list.get(list.size()-1);
	}
	
	public Business getByIdBusiness(int id) {
		
		Optional<Business> actBusiness = businessRepository.findById(id);
		
		return actBusiness.get();
		/*Business actBusiness = businessRepository.findById(id).orElse(null);
		if(null == actBusiness) {
			 new DtoNotFoundException(Business.class.toString(), id);
		}
		return actBusiness;*/
	}
	
	public Business saveBusiness(CreateBusinessInput business) {
		
		Area areafound = areaService.getAreaByName(business.getNameArea());
		Business newBusiness = new Business();
		newBusiness.setName(business.getNameBusiness());
		newBusiness.setAdress(business.getAddress());
		newBusiness.setDescription(business.getDescription());
		newBusiness.seteMail(business.geteMail());
		newBusiness.setNit(business.getNit());
		newBusiness.setPhone(business.getPhone());
		newBusiness.setArea(areafound);
		Business businessSaved= businessRepository.save(newBusiness);
		PriceQuotation quotation=priceQuotationRepository.findById(business.getIdQuotation()).orElse(null);
		quotation.setBusiness(businessSaved);
		priceQuotationRepository.save(quotation);
		return businessSaved;
	}
	
	
}
