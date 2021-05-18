package com.umss.dev.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationDetail;
import com.umss.dev.repository.PriceQoutationDetailRepository;

@Service
public class PriceQoutationDetailService {
	
	@Autowired
	private PriceQoutationDetailRepository priceQoutationDetailRepository;
	private ModelMapper modelMapper;
	
	public PriceQoutationDetailService(PriceQoutationDetailRepository priceQoutationDetailRepository, ModelMapper modelMapper) {
		this.priceQoutationDetailRepository = priceQoutationDetailRepository;
		this.modelMapper = modelMapper;
	}
	
	/*public Iterable<Student> getAll(){
		List<Student> allStudentResponse = studentRepository.findAll();
				/*.stream()
				.sorted(Comparator.comparing(Student::getStudentId))
				.map(student->{
					StudentResponse response = modelMapper.map(student, StudentResponse.class);
					response.setStudentId(student.getStudentId());
					return response;
		})    
	      		.collect(Collectors.toList());//
	return allStudentResponse;
		
	}*/
	
	public void getAllWithNull(PriceQuotation priceQuotation){
		System.out.println("***************************************// idOfLastQuotation"+ priceQuotation.getIdPriceQuotation() );
		List<PriceQuotationDetail> allPriceQuotationDetails = priceQoutationDetailRepository.findAll();
		Set <PriceQuotationDetail> allPriceQuotationDetailsWithNull = new HashSet<>();
		for (PriceQuotationDetail act: allPriceQuotationDetails) {
			if (act.getPriceQuotation()== null) {
				allPriceQuotationDetailsWithNull.add(act);
			}
		}
		
		for (PriceQuotationDetail actNull: allPriceQuotationDetailsWithNull) {
			actNull.setPriceQuotation(priceQuotation);
			priceQoutationDetailRepository.save(actNull);
		}
	}
	
}
