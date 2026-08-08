package com.dcl.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotBlank(message="*User Name cannot be empty!")
	private String name;
	
	@NotBlank(message = "User Email cannot be empty!")
	@Email(message = "Kindly enter valid Email Id")
	@Column(unique=true)
	private String email;
	
	@Length(min = 10,max = 10, message = "Phone number cannot exceed 10 digits!")
	@NotBlank(message = "Phone Number cannot be empty!")
	@Column(unique=true)
	private String phone;
}
