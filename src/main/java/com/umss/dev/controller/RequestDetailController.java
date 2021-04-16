package com.umss.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umss.dev.entity.RequestDetail;
import com.umss.dev.service.RequestDetailService;


@RestController
@RequestMapping("/api/details")
public class RequestDetailController {
	
	   @Autowired
	   private RequestDetailService RequestDetailservice;
}
