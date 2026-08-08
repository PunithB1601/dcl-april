package com.mmt.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PassengerDto {

	private String passengerName;
	
	private String from;
	
	private String to;
	
	private LocalDate journeyDate;
}
