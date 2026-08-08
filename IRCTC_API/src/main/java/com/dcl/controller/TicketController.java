package com.dcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.dto.TicketDto;
import com.dcl.request.TicketRequest;
import com.dcl.service.TicketService;


@RestController
@RequestMapping("/irctc")
public class TicketController {

	@Autowired
	private TicketService tservice;
	
	@PostMapping("/book")
	public ResponseEntity<?> bookTicket(@RequestBody TicketRequest request){
		TicketDto dto=tservice.bookTicket(request);
		return ResponseEntity.ok(dto);
	}
}
