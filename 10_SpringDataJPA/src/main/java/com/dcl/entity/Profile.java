package com.dcl.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	
	private String fname;
	
	private String lname;
	
	@Column(unique=true)
	private String phone;
	
	private LocalDate dob;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
}
