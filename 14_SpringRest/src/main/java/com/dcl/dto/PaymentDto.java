package com.dcl.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentDto {
	
private Integer orderId;
	
	private String razorPayOrderId;
	
	private Double amount;
	
	private String currency;
	
	private LocalDateTime createdAt;
	
	private String status;

}
