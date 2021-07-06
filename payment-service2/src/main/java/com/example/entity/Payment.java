package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PAYMENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {

	@Id
	@GeneratedValue
	
	private int paymentId;
	private String paymentStatus;
	//private String transactionId;
	public String TransactionId;
	
	private int orderId;
	private double amount;
	
	public Payment(int paymentId, String paymentStatus, String TransactionId, int orderId, int amount) {
		super();
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.TransactionId = TransactionId;
		this.orderId = orderId;
		this.amount = amount;
	}
	
	
	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
//	public String getSetTransactionId() {
//		return setTransactionId;
//	}
	public void SetTransactionId(String TransactionId) {
		this.TransactionId = TransactionId;
	}
//	public String getTransactionId() {
//		return transactionId;
//	}
	

	
}
