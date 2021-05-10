package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Area;
import com.umss.dev.entity.Business;
import com.umss.dev.exception.DtoNotFoundException;
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
	
	public Iterable<Business> getBusinessByIdArea(int idArea){
		Area areaAct = areaRepository.findById(idArea).orElse(null);
	    if (null == areaAct) {
	        throw new DtoNotFoundException(Area.class.toString(), idArea);
	    }
	    return areaAct.getBusiness();
	}
	
	public Iterable<Business> getBusinessByArea(String areaName){
		List<Business> businessFound = new ArrayList<>();
		List<Area> allArea = areaRepository.findAll();
		for (Area actArea : allArea ) {
			if(actArea.getName().equals(areaName)) {
				businessFound = actArea.getBusiness();
			}
			
		}
		
		return businessFound;
	}
}