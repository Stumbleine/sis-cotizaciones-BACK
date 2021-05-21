package com.umss.dev.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umss.dev.entity.DocumentQuotation;
import com.umss.dev.entity.Report;
import com.umss.dev.output.PriceQuotationIdOutput;
import com.umss.dev.output.ReportOutput;
import com.umss.dev.service.ReportService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/report") // api/report
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	
	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}

	

}
