package com.mmt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passengerId;
	
	private String passengerName;
	
	private String pfrom;
	
	private String pto;
	
	private LocalDate journeyDate;
}
