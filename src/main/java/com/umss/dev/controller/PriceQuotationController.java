package com.umss.dev.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import java.util.Optional;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.output.CompletePriceQuotationOutput;
import com.umss.dev.repository.PriceQuotationRepository;
import com.umss.dev.service.PriceQuotationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/quotation")
public class PriceQuotationController {
	
	private PriceQuotation lastPriceQuotationSaved;

	@Autowired
	private PriceQuotationService priceQuotationService;
	private PriceQuotationRepository priceQuotationRepository;
	private ModelMapper modelMapper;
	
	public PriceQuotationController(PriceQuotationRepository priceQuotationRepository, ModelMapper modelMapper) {
		this.priceQuotationRepository = priceQuotationRepository;
		this.modelMapper = modelMapper;
		lastPriceQuotationSaved = new PriceQuotation();
	}
	
	/*@PostMapping
	public ResponseEntity<PriceQuotation> create(@RequestBody PriceQuotation priceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.save(priceQuotation));
	}*/
	
	@PostMapping
	public ResponseEntity<PriceQuotation> create(@RequestBody PriceQuotation priceQuotation){
		PriceQuotation request = priceQuotation;
		lastPriceQuotationSaved = request;
		priceQuotationService.save(priceQuotation);
		return ResponseEntity.ok(request);
	}
	
	@GetMapping("/getIdOfNewQuotation")
	public CompletePriceQuotationOutput getIdOfNewQuotation(){
		CompletePriceQuotationOutput newQuotation = new CompletePriceQuotationOutput();
		newQuotation.setIdPriceQuotation(lastPriceQuotationSaved.getIdPriceQuotation());
		return newQuotation;
	}
	
	@PutMapping("/updateQuotation")
	public ResponseEntity<Object> updateQuotation(@RequestBody PriceQuotation newQuotation) {
		int id = lastPriceQuotationSaved.getIdPriceQuotation();
		Optional<PriceQuotation> quotationOptional = priceQuotationRepository.findById(id);

		if (!quotationOptional.isPresent())
			return ResponseEntity.notFound().build();

		newQuotation.setIdPriceQuotation(id);
		
		priceQuotationRepository.save(newQuotation);

		return ResponseEntity.noContent().build();
	}
	
	
	/*@PutMapping("/updateQuotation/")
	 Public PriceQuotation updateQuotation(@RequestBody PriceQuotation newQuotation) {
		int id = lastPriceQuotationSaved.getIdPriceQuotation();
		
	    return priceQuotationRepository.findById(id).map(quotation -> {
	        quotation.setWayOfPayment(newQuotation.getWayOfPayment());
	        quotation.setGarantyTerm(newQuotation.getGarantyTerm());
	        quotation.setDeliveryTerm(newQuotation.getDeliveryTerm());
	        quotation.setOffValidation(newQuotation.getOffValidation());
	        quotation.setTotal(newQuotation.getTotal());
	        quotation.setPriceQuotationDetail(newQuotation.getPriceQuotationDetail());
	        return repository.save(quotation);
	      })
	      .orElseGet(() -> {
	    	 newQuotation.setId(id);
	        return repository.save(newQuotation);
	      });
	  }*/
	/*@PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }*/
	
	/*@GetMapping("/{id}")
	public ResponseEntity<CompletePriceQuotationOutput> priceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.getPriceQuotation(idPriceQuotation));
	}*/

}
