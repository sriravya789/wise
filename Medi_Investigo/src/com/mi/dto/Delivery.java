package com.mi.dto;

public class Delivery {
	private String status;
	private Orders transactionId;
	public Delivery(){}

	public Delivery(String status) {
		super();
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public Orders getTransactionId() {
		return transactionId;
	}
	 public void setTransactionId(Orders transactionId) {
		this.transactionId = transactionId;
	}

	
	@Override
	public String toString() {
		return "Delivery [Status=" + status  + "transactionId=" + transactionId + "]";
	}
}
