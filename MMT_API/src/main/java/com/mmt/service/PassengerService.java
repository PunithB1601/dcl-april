package com.mmt.service;

import com.mmt.dto.TicketDto;
import com.mmt.request.TicketRequest;

public interface PassengerService {

	TicketDto bookTicket(TicketRequest request);
	
	TicketDto getTicketById(Integer ticketId);
	
}
