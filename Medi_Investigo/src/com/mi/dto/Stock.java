package com.mi.dto;

public class Stock {
	private int id;
	private String medicineName;
	private String generic;
	private String brand;
	private int quantity;
    private double price;
    private String manufacturer;
   	private Pharmacy pharmacyId;
	public Stock(){}

	public Stock(int id, String medicineName,String generic, String brand, int quantity, double price, String manufacturer) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.generic = generic;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		this.manufacturer = manufacturer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getGeneric() {
		return generic;
	}
	public void setGeneric(String generic) {
		this.generic = generic;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Pharmacy getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(Pharmacy pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	@Override
	public String toString() {
		return "Stock [Id=" + id + ", Medicine_Name=" + medicineName + ", Generic=" + generic
				+ ", Brand=" + brand + ", Quantity=" + quantity + ",Price=" + price + ",Manufacturer=" + manufacturer + "PharmacyId=" + pharmacyId + "]";
	}
}
