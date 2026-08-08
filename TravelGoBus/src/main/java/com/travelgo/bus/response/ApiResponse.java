package com.travelgo.bus.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {

	private T t;
	
	private String message;
	
	private HttpStatus httpStatus;
}
