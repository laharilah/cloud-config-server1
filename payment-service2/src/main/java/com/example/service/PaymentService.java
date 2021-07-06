package com.example.service;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Payment;
import com.example.repository.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository repository;
	
	//private Logger log=(Logger) LoggerFactory.getLogger(PaymentService.class);
	
	public Payment doPayment(Payment payment)
	{
		payment.setPaymentStatus(paymentProcessing());
		  payment.SetTransactionId(UUID.randomUUID().toString());
		  //log.info("PaymentService request : {}", new ObjectMapper().writeValueAsString(payment));
		return repository.save(payment);
	}

	
	
	public String paymentProcessing()
	{
		return new Random().nextBoolean()?"success":"false";
	}

//	public Payment findPaymentHistoryByOrderId(int orderId) {
//		Payment payment=repository.findByOrderId(orderId);
//		 //log.info("PaymentService findPaymentHistoryByOrderId : {}", new ObjectMapper().writeValueAsString(payment));
//		return payment;
//	}
//	
}
