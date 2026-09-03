package com.dcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.dto.PaymentDto;
import com.dcl.request.PaymentRequest;
import com.dcl.response.ApiResponse;
import com.dcl.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService pservice;

	@PostMapping("/pay")
	public ResponseEntity<?> makePayment(@RequestBody PaymentRequest request){
		PaymentDto dto=pservice.makePayment(request);
		ApiResponse response=new ApiResponse<>("Payment Request Sent!", dto, HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
}
