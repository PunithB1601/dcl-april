package com.travelgo.bus.entity;

import java.time.LocalDate;

import com.travelgo.bus.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	private String name;
	
	private String phone;
	
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	private String profileImage;
	
	@OneToOne
	@JoinColumn(name="user_id", nullable = false,unique = true)
	private User user;

}
