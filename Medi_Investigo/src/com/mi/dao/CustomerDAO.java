package com.mi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.dbutility.DBConnection;
import com.mi.dto.Customer;
import com.mi.dto.Pharmacy;
import com.mi.dto.Stock;

public class CustomerDAO {
	public int add(Customer customer){
		final String INSERT_QUERY="insert into customer(Name,Password,Gender,HNo,Street,Village,District,State,Pincode,PhoneNo,EmailId) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		int status=0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getPassword());
			pst.setString(3, customer.getGender());
			pst.setString(4, customer.gethNo());
			pst.setString(5, customer.getStreet());
			pst.setString(6, customer.getVillage());
			pst.setString(7, customer.getDistrict());
			pst.setString(8, customer.getState());
			pst.setInt(9, customer.getPincode());
			pst.setInt(10, customer.getPhoneNo());
			pst.setString(11, customer.getEmailId());
			status=pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return status;
		}
	public Customer getCustomer(int id,String password){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Customer customer=null;
	final String SELECT_QUERY = "select * from customer where id = ? and password = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, id);
		pst.setString(2, password);
		rst = pst.executeQuery();
		if(rst.next()){
			 customer=new Customer();
			 customer.setId(rst.getInt(1));

			 customer.setName(rst.getString(2));
			 customer.setPassword(rst.getString(3));
			 customer.setGender(rst.getString(4));
			 customer.sethNo(rst.getString(5));
			 customer.setStreet(rst.getString(6));
			 customer.setVillage(rst.getString(7));
			 customer.setDistrict(rst.getString(8));
			 customer.setState(rst.getString(9));			 
			 customer.setPincode(rst.getInt(10));
			 customer.setPhoneNo(rst.getInt(11));
			 customer.setEmailId(rst.getString(12));

		System.out.println(customer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return customer;
	}
	public List<Customer> getAllCustomers(){

		List<Customer> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select Id,Name,Password,Gender,HNo,Street,Village,District,State,Pincode,PhoneNo,EmailId from customer ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Customer customer=new Customer();
			
			customer.setId(rst.getInt(1));
			customer.setName(rst.getString(2));
			customer.setPassword(rst.getString(3));
			customer.setGender(rst.getString(4));
			customer.sethNo(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setVillage(rst.getString(7));
			customer.setDistrict(rst.getString(8));
			customer.setState(rst.getString(9));			 
			customer.setPincode(rst.getInt(10));
			customer.setPhoneNo(rst.getInt(11));
			customer.setEmailId(rst.getString(12));
			list.add(customer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int delete(int id) {
		final String DELETE_QUERY="delete from Customer where id=?";
		PreparedStatement pst = null;
		
		int status=0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(DELETE_QUERY);
			pst.setInt(1, id);
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void editEntry (String name, String password, String gender, String hNo, String street, String village,String district, String state, int pincode, int phoneNo, String emailId) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    Customer customer = null;
	    
	    
	    final String UPDATE_QUERY = "update Customer set name = ?, password = ? ,gender = ?,hNo = ?,street = ?,village = ?,district = ?,state = ?,pincode = ?,phoneNo = ?, where id = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setString(1, name);
		    pst.setString(2, password);
		    pst.setString(3, gender);
		    pst.setString(4,  hNo);
		    pst.setString(5, street);
		    pst.setString(6,village);
		    pst.setString(7, district);
		    pst.setString(8, state);
		    pst.setInt(9, pincode);
		    pst.setInt(10, phoneNo);
		    pst.setString(11, emailId);

		    rst = pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
	public Customer getDetails(int id){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Customer customer=null;
	final String SELECT_QUERY = "select * from customer where id= ?";
	try {
	    Connection con = DBConnection.getConnection();
		
		pst = con.prepareStatement(SELECT_QUERY);
		//pst.setString(1, userName);
		pst.setInt(1, id);
		rst = pst.executeQuery();
		if(rst.next()){
			 customer=new Customer();
			// System.out.println(rst.getInt(1));
			 
			 customer.setName(rst.getString(1));
			 customer.setPassword(rst.getString(2));
			 customer.setGender(rst.getString(3));
			 customer.sethNo(rst.getString(4));
			 customer.setStreet(rst.getString(5));
			 customer.setVillage(rst.getString(6));
			 customer.setDistrict(rst.getString(7));
			 customer.setState(rst.getString(8));
			 customer.setPincode(rst.getInt(9));
			 customer.setPhoneNo(rst.getInt(10));
			 customer.setEmailId(rst.getString(11));

		System.out.println(customer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return customer;
	}
	public List<Stock> searchMedicine(int pincode,String medicineName) {
		PreparedStatement pst = null;
		List<Stock>	stockList=new ArrayList<>();
		
		ResultSet rst = null;
		Customer customer=null;
		medicineName=medicineName.substring(0, 3)+"%";
	final String SELECT_QUERY="select s.MedicineName,s.Generic,s.Brand,s.Quantity,s.Price,s.Manufacturer,p.Name,"
			+ "p.Street,p.Village,p.District,p.State,p.Pincode from stock s,pharmacy p where "
			+ "s.MedicineName  like(?) or s.generic  like(?) or brand like(?) or p.id=s.PharmacyId and p.Pincode=?";
	try {
	    Connection con = DBConnection.getConnection();
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, medicineName);
		pst.setString(2, medicineName);
		pst.setString(3, medicineName);
		pst.setInt(4, pincode);

		
		rst = pst.executeQuery();
		while(rst.next()){
			Stock stock=new Stock();
			stock.setMedicineName(rst.getString(1));
			stock.setGeneric(rst.getString(2));
			stock.setBrand(rst.getString(3));
			stock.setQuantity(rst.getInt(4));
			stock.setPrice(rst.getDouble(5));
			stock.setManufacturer(rst.getString(6));
			Pharmacy pharmacy=new Pharmacy();
			pharmacy.setName(rst.getString(7));
			pharmacy.setStreet(rst.getString(8));
			pharmacy.setVillage(rst.getString(9));
			pharmacy.setDistrict(rst.getString(10));
			pharmacy.setState(rst.getString(11));
			pharmacy.setPincode(rst.getInt(12));
			stock.setPharmacyId(pharmacy);
			
			stockList.add(stock);
			
			

			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return stockList;
		
	}
}
