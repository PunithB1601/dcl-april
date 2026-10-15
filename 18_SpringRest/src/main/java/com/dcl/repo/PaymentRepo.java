package com.dcl.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.entity.Payment;
import java.util.List;


@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	Optional<Payment> findByOrderId(Integer orderId);
	
	Optional<Payment> findByRazorPayOrderId(String razorPayOrderId);
	
}
