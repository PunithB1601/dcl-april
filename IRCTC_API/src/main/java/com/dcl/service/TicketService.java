package com.dcl.service;

import com.dcl.dto.TicketDto;
import com.dcl.request.TicketRequest;


public interface TicketService {

	TicketDto bookTicket(TicketRequest request);
	
	TicketDto getTicket(Integer ticketId);
}
