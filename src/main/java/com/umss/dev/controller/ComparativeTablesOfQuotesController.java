package com.umss.dev.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.ComparativeTableOfQuotes;
import com.umss.dev.entity.PriceQuotation;
import com.umss.dev.entity.PriceQuotationRequest;
import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.PriceQuotationOutput;
import com.umss.dev.output.PriceQuotationRequestOutput;
import com.umss.dev.service.ComparativeTableOfQuotesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/quotation_comparative") // api/quotation_comparative
public class ComparativeTablesOfQuotesController {
	
	@Autowired
	ComparativeTableOfQuotesService comparativeTableOfQuotesService;
	
	
	
    public ComparativeTablesOfQuotesController(ComparativeTableOfQuotesService comparativeTableOfQuotesService) {
		this.comparativeTableOfQuotesService = comparativeTableOfQuotesService;
	}

    @PostMapping("/{id}")
	public ResponseEntity<?> create(@RequestBody List<ComparativeTableOfQuotes> comparativeTableOfQuotes,@PathVariable Integer id){
    	
    	List<ComparativeTableOfQuotes> comparativeTable=comparativeTableOfQuotes;
    	for(ComparativeTableOfQuotes quotations:comparativeTable) {
    		comparativeTableOfQuotesService.save(quotations,id);
    	}
		
		return ResponseEntity.ok(comparativeTable);
	}

    @GetMapping("/{id}")
	public Iterable<ComparativeTableOfQuotes> getComparativeTableOfQuotesService(@PathVariable Integer id){
		
		return comparativeTableOfQuotesService.getComparativeTable(id);
	}
    
    @PutMapping("/{id}")
	public ResponseEntity<?> updateComparativeTableOfQuotes(@PathVariable Integer id, @RequestBody List<ComparativeTableOfQuotes> comparativeTableOfQuotes) {
		
    	List<ComparativeTableOfQuotes> comparativeTable=comparativeTableOfQuotes;
    	comparativeTable=comparativeTableOfQuotesService.update(id, comparativeTable);		
		return ResponseEntity.ok(comparativeTable);
	}
    /*
	@GetMapping()
	@ResponseBody
	public String getFoos(@RequestParam List<String> ids) {
	    return "IDs are " + ids;
	}*/
	
	/*@GetMapping("/test/{firstNameIds}")
	public String test(@PathVariable List<Integer> firstNameIds) {
	     //Example: pring your params
	     for(Integer param : firstNameIds) {
	        System.out.println("id: " + param);
	     }
	     return "Dummy";
	}
	
	@GetMapping("/{id}/quotation/{Ids}")
	public  Iterable<ComparativeTableOfQuotesOutput> getComparativeTablesOfQuotes(@PathVariable Integer id,@PathVariable List<Integer> Ids) {

		 System.out.println("LLega aqui 11");
	     return comparativeTableOfQuotesService.getPriceQuotation( id,Ids);
	}*/
}
