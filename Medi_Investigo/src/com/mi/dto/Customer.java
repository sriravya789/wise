package com.mi.dto;

public class Customer {
	private int id;
	private String name;
	private String password;
	private String gender;
	private String hNo;
	private String street;
	private String village;
	private String district;
	private String State;
	private int pincode;
	private int phoneNo;
	private String emailId;
	
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String password, String gender, String hNo, String street, String village,
			String district, String state, int pincode, int phoneNo, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.hNo = hNo;
		this.street = street;
		this.village = village;
		this.district = district;
		this.State = state;
		this.pincode = pincode;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String gethNo() {
		return hNo;
	}
	public void sethNo(String hNo) {
		this.hNo = hNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", hNo="
				+ hNo + ", street=" + street + ", village=" + village + ", district=" + district + ", State=" + State
				+ ", pincode=" + pincode + ", phoneNo=" + phoneNo + ", emailId=" + emailId + "]";
	}
	
	

}
