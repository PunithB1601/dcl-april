package com.dcl.service;

import java.util.List;

import com.dcl.dto.OrderDto;
import com.dcl.dto.ProductDto;
import com.dcl.request.OrderProductRequest;

public interface OrderService {

	List<ProductDto> getAllProducts();
	
	OrderDto orderProduct(OrderProductRequest request);
}
