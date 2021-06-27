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
import com.umss.dev.repository.AreaRepository;
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
	@Autowired
	private AreaRepository areaRepository;
	
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
		
		boolean isArea=isArea(business.getNameArea());
		Business newBusiness = new Business();
		newBusiness.setName(business.getNameBusiness());
		newBusiness.setAdress(business.getAddress());
		newBusiness.setDescription(business.getDescription());
		newBusiness.seteMail(business.geteMail());
		newBusiness.setNit(business.getNit());
		newBusiness.setPhone(business.getPhone());
	
		if(isArea) {
			Area areafound = areaService.getAreaByName(business.getNameArea());
			newBusiness.setArea(areafound);
		}
		else {
			Area newArea=new Area();
			newArea.setName(business.getNameArea());
			newBusiness.setArea(areaRepository.save(newArea));
			
		}
		Business businessSaved= businessRepository.save(newBusiness);
		PriceQuotation quotation=priceQuotationRepository.findById(business.getIdQuotation()).orElse(null);
		quotation.setBusiness(businessSaved);
		priceQuotationRepository.save(quotation);
		return businessSaved;
	}
	
	private boolean isArea(String name) {
		boolean isArea=false;
		int count=0;
		List<Area> allArea = areaRepository.findAll();

		for (Area areaAct: allArea) {
			if(areaAct.getName().equals(name)) {
				isArea=true;
				count++;
			}
			else {
				if(count==0) {
					isArea=false;
				}
			}
		}
		return isArea;
	}
}
