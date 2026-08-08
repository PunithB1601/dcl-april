package com.dcl.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketRequest {

	private String passengerName;
	
	private String from;
	
	private String to;
	
	private LocalDate journeyDate;
}
