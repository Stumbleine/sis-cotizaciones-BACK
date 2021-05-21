package com.umss.dev.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.umss.dev.entity.DocumentQuotation;
import com.umss.dev.service.DocumetQuotationService;

import antlr.StringUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/DocumentQuotation")
public class DocumetQuotationController {

	@Autowired
	private DocumetQuotationService documentService;
	
	@PostMapping
	public void uploadDocument(@RequestParam("document")MultipartFile file) {
		
			try {
				String nameFile=file.getOriginalFilename();
				
				DocumentQuotation documentQuotation= new DocumentQuotation();
				documentQuotation.setNameDocumenQuotaion(nameFile);
				documentQuotation.setContent(file.getBytes());
				documentQuotation.setSizeDocuemntQuotaion(file.getSize());
				
				documentService.saveDocumentQuotation(documentQuotation);
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	@GetMapping("/{id}")
	public void report(@PathVariable (value = "id") Integer id, HttpServletResponse reponse){
		try {
			DocumentQuotation documentQuotation = documentService.getById(id);
			
			reponse.setContentType("application/force-download");
			String headerKey= "Content-Disposition";
			String headerValue="attachment; fileName="+"INFORME-DE-RECHAZO.pdf";
			
			reponse.setHeader(headerKey, headerValue);
			
			ServletOutputStream outputStream=reponse.getOutputStream();
			
			outputStream.write(documentQuotation.getContent());
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
		//System.out.println(documentQuotation.getNameDocumenQuotaion());
	
	} 
}
