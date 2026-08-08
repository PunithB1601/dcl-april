package com.dcl.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	
	private String passengerName;
	
	private String tfrom;
	
	private String tto;
	
	private LocalDate journeyDate;
	
	private String trainNumber;
	
	private String ticketStatus;
}
