package com.dcl.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserDto {

	private Integer userId;
	
	private String username;
	
	private String email;
	
	private LocalDate createdAt;
}
