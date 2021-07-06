package com.example.common;

import com.example.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionRequest {

	private Order order;
	public TransactionRequest() {
		super();
		
	}
	public TransactionRequest(Order order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}
	private Payment payment;
	
	public Order getOrder() {
		return order;
	}
	public Payment getPayment() {
		return payment;
	}
	
	
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
