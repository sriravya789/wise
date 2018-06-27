package com.mi.dto;

public class Pharmacy {
	private int id;
	private String name;
	private String password;
	private String certificate;
	private String street;
	private String village;
	private String district;
	private String state;
	private int pincode;
	private String status;
	private Admin adminId;
	
	public Pharmacy(){}

	public Pharmacy(int id, String name,String password,String certificate,String street,String village,String district,String state,int pincode,String status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.certificate = certificate;
		this.street = street;
		this.village = village;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.status = status;
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
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
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
	}public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Admin getAdminId() {
		return adminId;
	}

	public void setId(Admin adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Pharmacy [Id=" + id + ", Name=" + name + ", Password=" + password + ", Certificate=" + certificate + ", Street=" + street + 
				",Village=" + village + ",District=" + district + ",State=" + state + ",Pincode=" + pincode + "Status=" + status + "AdminId=" + adminId + "]";
	}

}
