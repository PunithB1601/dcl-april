package com.mmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.dto.TicketDto;
import com.mmt.request.TicketRequest;
import com.mmt.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	private PassengerService pservice;
	
	@PostMapping("/book")
	public ResponseEntity<?> bookTicket(@RequestBody TicketRequest request){
		TicketDto dto=pservice.bookTicket(request);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/get/{ticketId}")
	public ResponseEntity<?> getTicket(@PathVariable Integer ticketId){
		TicketDto dto=pservice.getTicketById(ticketId);
		return ResponseEntity.ok(dto);
	}
}
