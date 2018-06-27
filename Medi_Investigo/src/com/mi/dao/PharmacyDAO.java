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

public class PharmacyDAO {
	public int add(Pharmacy pharmacy){
		final String INSERT_QUERY="insert into pharmacy(name,password,certificate,street,village,district,state,pincode) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, pharmacy.getName());
			pst.setString(2, pharmacy.getPassword());
			pst.setString(3, pharmacy.getCertificate());
			pst.setString(4, pharmacy.getStreet());
			pst.setString(5, pharmacy.getVillage());
			pst.setString(6, pharmacy.getDistrict());
			pst.setString(7, pharmacy.getState());
			pst.setInt(8, pharmacy.getPincode());
			pst.setString(9, pharmacy.getStatus());

			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
public Pharmacy getPharmacy(int id,String password){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Pharmacy pharmacy =null;
	final String SELECT_QUERY = "select Name,Password,Street,Village,District,State,Pincode,Status from pharmacy where Id = ? and Password = ?";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, id);
		pst.setString(2, password);
		rst = pst.executeQuery();
		System.out.println(rst +" srasdf");
		if(rst.next()){
			System.out.println("wekjf;;");
			 pharmacy=new Pharmacy();
			 pharmacy.setName(rst.getString(1));
			 pharmacy.setPassword(rst.getString(2));
			 pharmacy.setStreet(rst.getString(3));
			 pharmacy.setVillage(rst.getString(4));
			 pharmacy.setDistrict(rst.getString(5));
			 pharmacy.setState(rst.getString(6));			 
			 pharmacy.setPincode(rst.getInt(7));
			 pharmacy.setStatus(rst.getString(8));

		System.out.println("pharmacy is:"+pharmacy);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return pharmacy;
	}

	public List<Pharmacy> getAllPharmacies(){

		List<Pharmacy> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select Id,Name,Password,Certificate,Street,Village,District,State,Pincode,Status from pharmacy ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Pharmacy pharmacy=new Pharmacy();
			pharmacy.setId(rst.getInt(1));
			pharmacy.setName(rst.getString(2));
			pharmacy.setPassword(rst.getString(3));
			pharmacy.setCertificate(rst.getString(4));
			pharmacy.setStreet(rst.getString(5));
			pharmacy.setVillage(rst.getString(6));
			pharmacy.setDistrict(rst.getString(7));
			pharmacy.setState(rst.getString(8));
			pharmacy.setPincode(rst.getInt(9));			 
			pharmacy.setStatus(rst.getString(10));
			
			list.add(pharmacy);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int delete(int id) {
		final String DELETE_QUERY="delete from Pharmacy where id=?";
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
	public void editEntry (String name, String password, String certificate, String street, String village,String district, String state, int pincode, String status) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    Pharmacy pharmacy = null;
	    
	    
	    final String UPDATE_QUERY = "update Pharmacy set name = ?, password = ? ,certificate = ?,street = ?,village = ?,district = ?,state = ?,pincode = ?,status = ?, where id = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setString(1, name);
		    pst.setString(2, password);
		    pst.setString(3, certificate);
		    pst.setString(4, street);
		    pst.setString(5,village);
		    pst.setString(6, district);
		    pst.setString(7, state);
		    pst.setInt(8, pincode);
		    pst.setString(9, status);

		    rst = pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
public Pharmacy getDetails(int id){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Pharmacy pharmacy=null;
	final String SELECT_QUERY = "select * from pharmacy where id= ?";
	try {
	    Connection con = DBConnection.getConnection();
		
		pst = con.prepareStatement(SELECT_QUERY);
		//pst.setString(1, userName);
		pst.setInt(1, id);
		rst = pst.executeQuery();
		if(rst.next()){
			 pharmacy=new Pharmacy();
			// System.out.println(rst.getInt(1));
			 
			 pharmacy.setName(rst.getString(1));
			 pharmacy.setPassword(rst.getString(2));
			 pharmacy.setCertificate(rst.getString(3));
			 pharmacy.setStreet(rst.getString(4));
			 pharmacy.setVillage(rst.getString(5));
			 pharmacy.setDistrict(rst.getString(6));
			 pharmacy.setState(rst.getString(7));
			 pharmacy.setPincode(rst.getInt(8));
			 pharmacy.setStatus(rst.getString(9));
			 

		System.out.println(pharmacy);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return pharmacy;
	}
}
