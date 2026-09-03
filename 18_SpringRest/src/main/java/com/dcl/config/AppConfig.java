package com.dcl.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.razorpay.RazorpayClient;

import lombok.SneakyThrows;

@Configuration
public class AppConfig {

	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.key.secret}")
	private String razorPayKeySecret;
	
	@Bean
	@SneakyThrows
	public RazorpayClient getRazorPayClient() {
		return new RazorpayClient(razorPayKey, razorPayKeySecret);
	}
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
