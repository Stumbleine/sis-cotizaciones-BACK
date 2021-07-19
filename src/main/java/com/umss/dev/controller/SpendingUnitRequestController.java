package com.umss.dev.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;
import com.umss.dev.service.DocumetQuotationService;
import com.umss.dev.service.PriceQuotationRequestService;
import com.umss.dev.service.ReportService;
import com.umss.dev.service.SpendingUnitRequestService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/request") // api/request
public class SpendingUnitRequestController { 
	
	@Autowired
	SpendingUnitRequestService spendingUnitReqService;
	@Autowired
	private PriceQuotationRequestService priceQuotationRequestService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private DocumetQuotationService documetQuotationService;
	
	public SpendingUnitRequestController(SpendingUnitRequestService spendingUnitReqServ){
		spendingUnitReqService = spendingUnitReqServ;
	}
	@PreAuthorize("hasRole('CREAR_PEDIDO')")
	@PostMapping("{id}")
	public ResponseEntity<?> create(@RequestBody SpendingUnitRequest spendingUnitRequest,@PathVariable (value = "id") Integer userId){
		SpendingUnitRequest request=spendingUnitRequest;
		spendingUnitReqService.save(request,userId);
		
		return ResponseEntity.ok(request);
	}
	@PreAuthorize("hasRole('RAF')")	
	@GetMapping()
	public Iterable<SpendingUnitRequest> getSpendingUnitRequests(){
		
		return spendingUnitReqService.getAll();
	}
	//@PreAuthorize("hasRole('VER_DETALLE_PEDIDO') or hasRole('GESTIONAR_COTIZACIONES') or hasRole('TOMAR_DECISION')")
	@PreAuthorize("hasRole('VER_DETALLE_PEDIDO')")	
	@GetMapping("/allRequestsDescOrder")
	public Iterable<CompleteSpendingUnitRequestOutput> getAllReqByDescOrder(){
		
		return spendingUnitReqService.getAllWithoutDetailByOrder();
	}
	//@PreAuthorize("hasRole('VER_PEDIDO') or hasRole('VER_DETALLE_PEDIDO') or hasRole('GESTIONAR_COTIZACIONES') or hasRole('TOMAR_DECISION')")		
	@PreAuthorize("hasRole('VER_PEDIDO') or hasRole('VER_DETALLE_PEDIDO')")	
	@GetMapping("/{id}")
	public ResponseEntity<?> spendingUnitRequest(@PathVariable (value = "id") Integer spendingUnitRequestId){	
		
		return ResponseEntity.ok(spendingUnitReqService.getSpendingUnitRequeste(spendingUnitRequestId)) ;
	}
	
	@PreAuthorize("hasRole('TOMAR_DECISION') or hasRole('GESTIONAR_COTIZACIONES')")	
	@PutMapping("/{id}")
	public ResponseEntity<?> spendingUnitRequest(@PathVariable (value = "id") Integer spendingUnitRequestId,@RequestParam("state")String state,
												@RequestParam("comentary")String comentary,@RequestParam("document")MultipartFile file,@RequestParam("idQuotation")int idQuotation) throws IOException{
		SpendingUnitRequest request=spendingUnitReqService.getSpendingUnitRequestNormal(spendingUnitRequestId);
		int idPriceQuotation=0;
		int idReport=0;
		if(request.getStatus().compareTo("Pendiente")==0) {
			if(state.compareTo("Rechazado")==0 ) {//state.compareTo("Rechazado")==0 || state.compareTo("Aprobado")==0
				spendingUnitReqService.updateState(spendingUnitRequestId,state);
					
				idPriceQuotation= priceQuotationRequestService.createPriceQuotationRequest(spendingUnitReqService.getSpendingUnitRequestNormal(spendingUnitRequestId));
				idReport=reportService.createReport(idPriceQuotation,comentary);
				documetQuotationService.createDocument(file,idReport);
			}
			else {
				if(state.compareTo("Autorizado")==0) {
					spendingUnitReqService.updateState(spendingUnitRequestId,state);
					priceQuotationRequestService.createPriceQuotationRequest(request);
					
				}
			}
			
		
		}
		else {
			if(request.getStatus().compareTo("Autorizado")==0) {
				if(state.compareTo("Cotizando")==0) {
					spendingUnitReqService.updateState(spendingUnitRequestId,state);
				}
			}
			else {
				if(request.getStatus().compareTo("Cotizando")==0) {
					if(state.compareTo("Rechazado")==0 || state.compareTo("Aprobado")==0) {
						spendingUnitReqService.updateState(spendingUnitRequestId,state);
						idPriceQuotation=spendingUnitReqService.getSpendingUnitRequestNormal(spendingUnitRequestId).getPriceQuotation().getIdPriceQuotationRequest();
						idReport=reportService.createReport(idPriceQuotation,comentary);
						documetQuotationService.createDocument(file,idReport);
						
						if(idQuotation>0) {
							priceQuotationRequestService.upDateQuotationSelect(idQuotation);
						}
					}
					
				}
			}
		}
		
		//spendingUnitReqService.updateState(spendingUnitRequestId,state);
		
		return ResponseEntity.ok(spendingUnitReqService.getSpendingUnitRequeste(spendingUnitRequestId)) ;
	}
	
	@GetMapping("/getSpendingUnitRequestByStatus/{status}")
	public Iterable<SpendingUnitRequest> getAllSpendingUnitRequestByStatus(@PathVariable (value = "status") String status){
			
		return spendingUnitReqService.getAllSpendingUnitRequestByStatus(status);
		
	}
	
}