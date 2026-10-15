package com.dcl.request;

import lombok.Data;

@Data
public class VerificationRequest {

	private Integer orderId;
	
	private String razorpayOrderId;
	
	private String razorpayPaymentId;
	
	private String razorpaySignature;
}
