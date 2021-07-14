package com.umss.dev.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.modelmapper.ModelMapper;
import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import com.umss.dev.entity.Business;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.input.NewBusinessInput;
import com.umss.dev.input.PriceQuotationInput;
import com.umss.dev.output.PriceQuotationIdOutput;
import com.umss.dev.output.CompletePriceQuotation;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.repository.PriceQuotationRepository;
import com.umss.dev.service.BusinessService;
import com.umss.dev.service.PriceQuotationService;
import javax.validation.Valid;
//import org.json.JSONObject;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/quotation")
public class PriceQuotationController {
	
	private PriceQuotation lastPriceQuotationSaved;

	@Autowired
	private PriceQuotationService priceQuotationService;
	private PriceQuotationRepository priceQuotationRepository;
	private ModelMapper modelMapper;
	private BusinessService businessService;
	
	public PriceQuotationController(PriceQuotationRepository priceQuotationRepository, ModelMapper modelMapper, BusinessService businessService) {
		this.priceQuotationRepository = priceQuotationRepository;
		this.modelMapper = modelMapper;
		this.businessService = businessService;
		lastPriceQuotationSaved = new PriceQuotation();
	}
	
	/*@PostMapping
	public ResponseEntity<PriceQuotation> create(@RequestBody PriceQuotation priceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.save(priceQuotation));
	}*/
	
	@PreAuthorize("hasRole('RAF')")	
	@PostMapping("/createQuotation/{id}")
	public ResponseEntity<PriceQuotation> create(@Valid @RequestBody PriceQuotationInput priceQuotationInput, @PathVariable (value = "id") Integer idSpendingUnitRequest){
		System.out.println("********//********************//***********"+idSpendingUnitRequest);
		//priceQuotationInput.setIdSpendingUnitRequest(idSpendingUnitRequest);
		PriceQuotation request = priceQuotationService.save2(priceQuotationInput, idSpendingUnitRequest );
		lastPriceQuotationSaved = request;
		//priceQuotationService.saveOther(actPriceQuotation);
		return ResponseEntity.ok(request);
	}
	@PreAuthorize("hasRole('RAF')")	
	@GetMapping("/getIdOfNewQuotation")
	public PriceQuotationIdOutput getIdOfNewQuotation(){
		PriceQuotationIdOutput newQuotation = new PriceQuotationIdOutput();
		newQuotation.setIdPriceQuotation(lastPriceQuotationSaved.getIdPriceQuotation());
		return newQuotation;
	}
	
	@PermitAll
	@PutMapping("/updateQuotation/{id}")
	public ResponseEntity<Object> updateQuotation(@RequestBody PriceQuotation newQuotation, @PathVariable (value = "id") Integer idPriceQuotation) {
		//int id = lastPriceQuotationSaved.getIdPriceQuotation();
		System.out.println("********//********************//***********es esto 1");
		Optional<PriceQuotation> quotationOptional = priceQuotationRepository.findById(idPriceQuotation);
		PriceQuotationRequest act = priceQuotationService.getPriceQuotationRequestOfQuotation(idPriceQuotation);
		//Business actBusiness = businessService.getByIdBusiness(newQuotation.);
		if (!quotationOptional.isPresent())
			return ResponseEntity.notFound().build();

		newQuotation.setIdPriceQuotation(idPriceQuotation);
		newQuotation.setPriceQuotationRequest(act);
		
		priceQuotationRepository.save(newQuotation);

		return ResponseEntity.noContent().build();
	}
	
	@PermitAll
	@PutMapping("/updateQuotationAddingBusiness/{id}")
	public ResponseEntity<Object> updateQuotation(@Valid @RequestBody NewBusinessInput newBusiness, @PathVariable (value = "id") Integer idPriceQuotation) {
		System.out.println("********//********************//***********es esto 2");
		Optional<PriceQuotation> quotationOptional = priceQuotationRepository.findById(idPriceQuotation);
		PriceQuotationRequest act = priceQuotationService.getPriceQuotationRequestOfQuotation(idPriceQuotation);
		Business actBusiness = businessService.getByIdBusiness(newBusiness.getIdBusiness());
		PriceQuotation actQuotation= priceQuotationService.getByIdPriceQuotation(idPriceQuotation);
		
		if (!quotationOptional.isPresent())
			return ResponseEntity.notFound().build();

		actQuotation.setIdPriceQuotation(idPriceQuotation);
		actQuotation.setBusiness(actBusiness);
		
		priceQuotationRepository.save(actQuotation);

		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('RAF')")	
	@PutMapping("/RelatingPriceQuotationToDetails")
	public void relatePriceQuotationToDetails(@RequestBody PriceQuotation newQuotation) {
		priceQuotationService.relatePriceQuotitionToDetails();
	}

	
	@GetMapping("/getById/{id}")
	public ResponseEntity<CompletePriceQuotation> priceQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		return ResponseEntity.ok( priceQuotationService.findPriceQuotationById(idPriceQuotation));
	}

/*    
	@PutMapping("/updateSelectQuotation/{id}")
	public void selectQuotation(@PathVariable (value = "id") Integer idPriceQuotation){
		
		priceQuotationService.selecteQuotation(idPriceQuotation);
		
	}
	*/
	@PreAuthorize("hasRole('RAF')")	
	@DeleteMapping("/deleteQuotation/{id}")
	public void deleteQuotataion(@PathVariable (value = "id") int idQuotation) throws Exception {
		
		priceQuotationService.DeleteQuotation(idQuotation);
	}
}