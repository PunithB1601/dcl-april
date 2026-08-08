package com.mmt.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mmt.dto.TicketDto;
import com.mmt.request.TicketRequest;

@FeignClient(value = "irctc",url="http://localhost:8082/irctc")
public interface FeignService {

	@PostMapping("/book")
	TicketDto bookTicket(@RequestBody TicketRequest request);
	
	@GetMapping("/get/{ticketId}")
	TicketDto getTicket(Integer ticketId);
}
