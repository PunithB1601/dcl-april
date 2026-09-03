package com.dcl.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	private Integer orderId;
	
	private String razorPayPaymentId;
	
	private String razorPayOrderId;
	
	private Double amount;
	
	private String currency;
	
	private String status;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
	
	@PreUpdate
	public void setModifiedAt() {
		this.modifiedAt=LocalDateTime.now();
	}
}
