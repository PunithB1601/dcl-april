package com.mmt.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketDto {

	private Integer ticketId;
	
	private String passengerName;
	
	private String from;
	
	private String to;
	
	private LocalDate journeyDate;
	
	private String trainNumber;
	
	private String ticketStatus;
}
