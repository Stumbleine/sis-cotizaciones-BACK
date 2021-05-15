package com.umss.dev.controller;

import java.net.http.HttpResponse;
import java.net.http.HttpResponse.ResponseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.umss.dev.entity.ComparateTable;
import com.umss.dev.input.ComparateTableInput;
import com.umss.dev.output.ComparateTableOutput;
import com.umss.dev.service.ComparateTableService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/test") // api/request
public class ComparateTableController {

	@Autowired
	private ComparateTableService comparateTableService ;
	
	@PostMapping
	public void save(@RequestBody ComparateTableInput comparateTableInput){
		comparateTableService.saveComparateTable(comparateTableInput);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<ComparateTableOutput> getComparationTable(@PathVariable (value = "id")int id) {
		
		 return ResponseEntity.ok(comparateTableService.getComparateTable(id));
	}
}
