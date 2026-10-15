package com.dcl.service.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.dto.OrderDto;
import com.dcl.dto.PaymentDto;
import com.dcl.dto.ProductDto;
import com.dcl.entity.Orders;
import com.dcl.feignservice.PaymentFeignClientService;
import com.dcl.feignservice.ProductFeignClientService;
import com.dcl.repo.OrderRepository;
import com.dcl.request.OrderProductRequest;
import com.dcl.request.PaymentRequest;
import com.dcl.response.ApiResponse;
import com.dcl.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private PaymentFeignClientService paymentFeign;
	
	@Autowired
	private ProductFeignClientService feignClient;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OrderRepository orepo;
	
	
	@Override
	public List<ProductDto> getAllProducts() {
		
		ApiResponse response=feignClient.getAllProduct();
		List<ProductDto> productList=(List<ProductDto>)response.getData();
		return productList;
	}

	@Override
	public OrderDto orderProduct(OrderProductRequest request) {
		Orders order=new Orders();
		order.setProductId(request.getProductId());
		order.setQuantity(request.getQuantity());
		ApiResponse response=feignClient.getProductById(request.getProductId());
		Map<String, Object> pdtoMap=(Map<String, Object>)response.getData();
		ProductDto pdto=mapper.map(pdtoMap, ProductDto.class);
		Double totalPrice=request.getQuantity()*pdto.getPrice();
		order.setTotalPrice(totalPrice);
		order=orepo.save(order);
		
		PaymentRequest payRequest=new PaymentRequest();
		payRequest.setOrderId(order.getOrderId());
		payRequest.setAmount(totalPrice);
		
		ApiResponse paymentResponse=paymentFeign.makePayment(payRequest);
		Map<String, Object> paymentMap=(Map<String, Object>)paymentResponse.getData();
		PaymentDto paymentDto=mapper.map(paymentMap, PaymentDto.class);
		OrderDto dto =mapper.map(order, OrderDto.class);
		dto.setProductDto(pdto);
		dto.setPaymentDto(paymentDto);
		return dto;
	}

}
