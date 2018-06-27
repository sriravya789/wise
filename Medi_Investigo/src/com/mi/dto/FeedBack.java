package com.mi.dto;

public class FeedBack {
	private String feedback;

	private Orders transactionId;
	public FeedBack(){}

	public FeedBack(String feedback) {
		super();
		this.feedback = feedback;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Orders getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Orders transactionId) {
		this.transactionId = transactionId;
	}
	
	@Override
	public String toString() {
		return "Feedback [Feedback=" + feedback  + "TransactionId=" + transactionId + "]";
	}
}
