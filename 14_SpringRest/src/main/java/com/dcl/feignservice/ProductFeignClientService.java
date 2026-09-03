package com.dcl.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dcl.dto.ProductDto;
import com.dcl.response.ApiResponse;



@FeignClient(name="PRODUCT-SERVICE",path="/product")
public interface ProductFeignClientService {

	@GetMapping("/get")
	public ApiResponse<?> getAllProduct();
	
	@GetMapping("/get/{productId}")
	public ApiResponse<?> getProductById(@PathVariable Integer productId);
}
