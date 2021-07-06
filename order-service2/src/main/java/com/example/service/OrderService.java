package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.common.Payment;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.entity.Order;
import com.example.repository.OrderRepository;

@Service

public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;

	
	public TransactionResponse saveOrder(TransactionRequest request)
	{
		String response="";
		Order order= request.getOrder();
	    Payment payment=request.getPayment();    
    	payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		System.out.println(request.getOrder().getId());
	Payment paymentResponse=template.postForObject("http://localhost:9191/payment/doPayment", payment, Payment.class);
	System.out.println(paymentResponse.getTransactionId());
	response=paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api,order added to cart";
		 repository.save(order);
		 return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}
}
