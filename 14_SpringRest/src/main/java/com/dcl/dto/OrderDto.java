package com.dcl.dto;

import lombok.Data;

@Data
public class OrderDto {

	private Integer orderId;
	
	private ProductDto productDto;
	
	private Integer quantity;
	
	private PaymentDto paymentDto;
	
	private Double totalPrice;
}
