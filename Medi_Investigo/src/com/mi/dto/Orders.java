package com.mi.dto;

import java.sql.Date;

public class Orders {
	private int transactionId;
	private Date transactionDate;
	private double totalAmount;
	private String homeDelivery;


	public Orders(){}

	public Orders(int transactionId, Date transactionDate, double totalAmount, String homeDelivery) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.totalAmount = totalAmount;
		this.homeDelivery = homeDelivery;
	}
		
		public int getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getHomeDelivery() {
			return homeDelivery;
		}

		public void setHomeDelivery(String homeDelivery) {
			this.homeDelivery = homeDelivery;
		}
	

	@Override
	public String toString() {
		return "Orders [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", totalAmount="
				+ totalAmount + ", homeDelivery=" + homeDelivery + "]";
	}
	
}
