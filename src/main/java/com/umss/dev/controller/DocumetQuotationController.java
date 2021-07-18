package com.umss.dev.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.umss.dev.entity.DocumentQuotation;
import com.umss.dev.output.DocumentQuotationAtributesOutput;
import com.umss.dev.service.DocumetQuotationService;

import antlr.StringUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/Document")
public class DocumetQuotationController {

	@Autowired
	private DocumetQuotationService documentService;
	
	@PreAuthorize("hasRole('RAF') or hasRole('RUG')")	
	@PostMapping("/{id}")
	public ResponseEntity<DocumentQuotation> uploadDocument(@PathVariable (value = "id") Integer id,@RequestParam("document")MultipartFile file) {
		
		return ResponseEntity.ok( documentService.saveDocumentQuotation(file,id));	
		
		
	}
	
	@GetMapping("downloadDocument/{id}")
	public void report(@PathVariable (value = "id") Integer id, HttpServletResponse reponse){
		try {
			DocumentQuotation documentQuotation = documentService.getById(id);
			
			reponse.setContentType("application/force-download");
			String headerKey= "Content-Disposition";
			String headerValue="attachment; fileName="+documentQuotation.getNameDocumenQuotaion();
			
			reponse.setHeader(headerKey, headerValue);
			
			ServletOutputStream outputStream=reponse.getOutputStream();
			
			outputStream.write(documentQuotation.getContent());
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
		//System.out.println(documentQuotation.getNameDocumenQuotaion());
	
	} 
	
	@PreAuthorize("hasRole('RAF')")		
	@GetMapping("/Quotation/{id}")
	public ResponseEntity<DocumentQuotationAtributesOutput> priceQuotation(@PathVariable (value = "id") Integer id) {
		
		return  ResponseEntity.ok( documentService.getDocumneByIdPriceQuotation(id));
	}
	@PreAuthorize("hasRole('RAF') or hasRole('ROLE_VER_INFORME')")
	@GetMapping("/Report/{id}")
	public ResponseEntity<DocumentQuotationAtributesOutput> report(@PathVariable (value = "id") Integer id) {
		
		return  ResponseEntity.ok(documentService.getDocumneByIdReport(id));
	}
	@PreAuthorize("hasRole('RAF') or hasRole('ROLE_VER_INFORME')")
	@GetMapping("/blob/Report/{id}")
	public byte[] blob(@PathVariable (value = "id") Integer id) {
		
		return documentService.getDocumneByIdReport(id).getContent();
	}
	@PreAuthorize("hasRole('RAF') or hasRole('RUG')")	
	@GetMapping("/blob/Quotation/{id}")
	public byte[] blobQuotation(@PathVariable (value = "id") Integer id) {
		
		return  documentService.getDocumneByIdQuotation(id).getContent();
	}
	@PreAuthorize("hasRole('RAF')")
	@DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<DocumentQuotationAtributesOutput> deleteDocumentQuotation(@PathVariable Integer id) {

        return  ResponseEntity.ok(documentService.deleteDocumentByIdPriceQuotation(id));
    }
	@PreAuthorize("hasRole('RAF')")
	@PostMapping("/uploadDetail")
	public ResponseEntity<DocumentQuotation> uploadDocumentDetail(@RequestParam (value = "idRow") Integer id,@RequestParam("document")MultipartFile file) {
		
		return ResponseEntity.ok( documentService.saveDocumentQuotationDetail(file,id));		
	}
	
	@PreAuthorize("hasRole('RAF')")	
	@GetMapping("/blob/ItemDocument/{id}")
	public byte[] blobItemDocument(@PathVariable (value = "id") Integer id) {
		
		return  documentService.bobItemDocument(id);
	}
}