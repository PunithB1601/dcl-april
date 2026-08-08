package com.travelgo.bus.request;

import java.time.LocalDate;

import com.travelgo.bus.enums.Gender;

import lombok.Data;

@Data
public class UserProfileRegisterRequest {

	private String name;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private LocalDate dob;
	
	private Gender gender;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
}
