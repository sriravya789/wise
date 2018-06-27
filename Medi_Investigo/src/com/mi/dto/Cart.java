package com.mi.dto;

public class Cart {
	private int quantity;
	private double price;
	private Customer id;
	private Stock stockId;
	private Orders transactionId;
	public Cart(){}

	public Cart(int quantity, double price, int sNo) {
		super();
		this.quantity = quantity;
		this.price = price;
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Customer getId() {
		return id;
	}

	public void setId(Customer id) {
		this.id = id;
	}

	public Orders getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Orders transactionId) {
		this.transactionId = transactionId;
	}
	public Stock getStockId() {
		return stockId;
	}

	public void setStockId(Stock stockId) {
		this.stockId = stockId;
	}
	@Override
	public String toString() {
		return "Cart [Quantity=" + quantity + ", Price=" + price + ", TransactionId=" + transactionId + "CustomerId=" + id + "StockId=" + stockId + "]";
	}
}
