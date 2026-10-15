package com.dcl.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dcl.request.PaymentRequest;
import com.dcl.response.ApiResponse;

@FeignClient(name="PAYMENT-SERVICE", path="/payment")
public interface PaymentFeignClientService {

	@PostMapping("/pay")
	public ApiResponse<?> makePayment(@RequestBody PaymentRequest request);
}
