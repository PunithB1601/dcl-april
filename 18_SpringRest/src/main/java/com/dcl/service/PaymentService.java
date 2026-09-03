package com.dcl.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dcl.dto.PaymentDto;
import com.dcl.entity.Payment;
import com.dcl.repo.PaymentRepo;
import com.dcl.request.PaymentRequest;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.SneakyThrows;

@Service
public class PaymentService {

	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.key.secret}")
	private String razorPayKeySecret;
	
	@Autowired
	private RazorpayClient rpClient;
	
	@Autowired
	private PaymentRepo prepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@SneakyThrows
	public PaymentDto makePayment(PaymentRequest request) {
		
		Map<String, Object> paymentMap=new HashMap<>();
		
		Integer paise=(int)(request.getAmount()*100);
		paymentMap.put("amount", paise);
		paymentMap.put("currency", "INR");
		paymentMap.put("receipt", "order_"+request.getOrderId());
		
		JSONObject jsonObject=new JSONObject(paymentMap);
		
		//Creating a RazorPay Order
		Order razorPayOrder=rpClient.orders.create(jsonObject);
		
		Payment payment=new Payment();
		payment.setOrderId(request.getOrderId());
		payment.setAmount(request.getAmount());
		payment.setCurrency("INR");
		payment.setStatus("PENDING");
		payment.setRazorPayOrderId(razorPayOrder.get("id"));
		
		prepo.save(payment);
		
		return mapper.map(payment, PaymentDto.class);
	}
}
