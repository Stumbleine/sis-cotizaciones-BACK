package com.umss.dev.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.Business;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.exception.DtoNotFoundException;
import com.umss.dev.repository.BusinessRepository;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;
	private ModelMapper modelMapper;
	
	public BusinessService(BusinessRepository businessRepository, ModelMapper modelMapper) {
		super();
		this.businessRepository = businessRepository;
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
	
	public Business getByIdBusiness(int id) {
		
		Optional<Business> actBusiness = businessRepository.findById(id);
		
		return actBusiness.get();
		/*Business actBusiness = businessRepository.findById(id).orElse(null);
		if(null == actBusiness) {
			 new DtoNotFoundException(Business.class.toString(), id);
		}
		return actBusiness;*/
		
		
	}
	
}
