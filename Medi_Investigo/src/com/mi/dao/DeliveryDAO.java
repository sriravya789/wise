package com.mi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.dbutility.DBConnection;
import com.mi.dto.Customer;
import com.mi.dto.Delivery;
import com.mi.dto.Orders;
import com.mi.dto.Pharmacy;
import com.mi.dto.Stock;

public class DeliveryDAO {
	public int add(Delivery delivery){
		final String INSERT_QUERY="insert into stock(ordersTransactionId,status) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, delivery.getTransactionId().getTransactionId());
			pst.setString(2, delivery.getStatus());
			
			

			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
public Delivery getDelivery(int TransactionId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Delivery delivery=null;
	final String SELECT_QUERY = "select status from delivery where ordersTransactionId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
	    
		pst.setInt(1, TransactionId);
		rst = pst.executeQuery();
		if(rst.next()){
			 delivery=new Delivery();
			 delivery.setStatus(rst.getString(1));
			 
			 

		System.out.println(delivery);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return delivery;
	}
	public List<Delivery> getAllDelivery(){

		List<Delivery> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from delivery ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Delivery delivery=new Delivery();
			Orders orders = new Orders();
			orders.setTransactionId(rst.getInt(1));
			delivery.setTransactionId(orders);
			
			delivery.setStatus(rst.getString(2));
			
			list.add(delivery);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int delete(int ordersTransactionId) {
		final String DELETE_QUERY="delete from Delivery where ordersTransactionId=?";
		PreparedStatement pst = null;
		
		int status=0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(DELETE_QUERY);
			pst.setInt(1, ordersTransactionId);
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void editEntry (int ordersTransactionId , String status) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    Delivery delivery = null;
	    
	    
	    final String UPDATE_QUERY = "update Customer set ordersTransactionId = ?, status = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setInt(1, ordersTransactionId);
		    pst.setString(2, status);
		    

		    rst = pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
