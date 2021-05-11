package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Area;
import com.umss.dev.entity.Business;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.output.BusinessOutput;
import com.umss.dev.repository.AreaRepository;

@Service
public class AreaService {

	@Autowired
	private AreaRepository areaRepository;
	private ModelMapper modelMapper;
	
	public AreaService (AreaRepository areaRepository, ModelMapper modelMapper) {
		
		this.areaRepository = areaRepository;
		this.modelMapper = modelMapper;
		
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
	
	public Iterable<BusinessOutput> getBusinessByIdArea(int idArea){
		Area areaAct = areaRepository.findById(idArea).orElse(null);
		List<BusinessOutput> businessFound = new ArrayList<>();
	    if (null == areaAct) {
	        throw new DtoNotFoundException(Area.class.toString(), idArea);
	    }
	     //System.out.println("----------------------------------------"+areaAct.getBusiness().isEmpty());
	     
	    for (Business actBusiness: areaAct.getBusiness()){
	    		if(!(businessFound.contains(actBusiness))) {
	    			BusinessOutput newBusiness = new BusinessOutput();
	    			newBusiness.setIdBusiness(actBusiness.getIdBusiness());
	    			newBusiness.setName(actBusiness.getName());
	    			newBusiness.setAdress(actBusiness.getAdress());
	    			newBusiness.setDescription(actBusiness.getDescription());
	    			newBusiness.seteMail(actBusiness.geteMail());
	    			newBusiness.setNit(actBusiness.getNit());
	    			newBusiness.setPhone(actBusiness.getPhone());
	    			businessFound.add(newBusiness);
	    		}
	    }
	    
	    return businessFound;
	    
	}
	
	public Iterable<BusinessOutput> getBusinessByArea(String areaName){
		List<BusinessOutput> businessFound = new ArrayList<>();
		List<Area> allArea = areaRepository.findAll();
		for (Area actArea : allArea ) {
			if(actArea.getName().equals(areaName)) {
				 for (Business actBusiness: actArea.getBusiness()){
			    		if(!(businessFound.contains(actBusiness))) {
			    			BusinessOutput newBusiness = new BusinessOutput();
			    			newBusiness.setIdBusiness(actBusiness.getIdBusiness());
			    			newBusiness.setName(actBusiness.getName());
			    			newBusiness.setAdress(actBusiness.getAdress());
			    			newBusiness.setDescription(actBusiness.getDescription());
			    			newBusiness.seteMail(actBusiness.geteMail());
			    			newBusiness.setNit(actBusiness.getNit());
			    			newBusiness.setPhone(actBusiness.getPhone());
			    			businessFound.add(newBusiness);
			    		}
			    }
			}
			
		}
		
		return businessFound;
	}
}