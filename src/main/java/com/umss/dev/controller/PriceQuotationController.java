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

import javax.annotation.security.PermitAll;

import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.output.PriceQuotationIdOutput;
import com.umss.dev.output.CompletePriceQuotation;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.PriceQuotationOutput;
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
	
	@PermitAll
	@PostMapping()
	public ResponseEntity<PriceQuotation> create(@RequestBody PriceQuotation priceQuotation){
		//priceQuotation.
		PriceQuotation request = priceQuotation;
		lastPriceQuotationSaved = request;
		priceQuotationService.saveOther(priceQuotation);
		return ResponseEntity.ok(request);
	}
	
	@GetMapping("/getIdOfNewQuotation")
	public PriceQuotationIdOutput getIdOfNewQuotation(){
		PriceQuotationIdOutput newQuotation = new PriceQuotationIdOutput();
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
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<CompletePriceQuotation> priceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.findPriceQuotationById(idPriceQuotation));
	}
    
	
}
