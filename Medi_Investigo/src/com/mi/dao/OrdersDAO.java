package com.mi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.dbutility.DBConnection;
import com.mi.dto.Orders;

public class OrdersDAO {
	public int add(Orders orders){
		final String INSERT_QUERY="insert into orders(transactionId,transactionDate,totalAmount,homeDelivery,) values(?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, orders.getTransactionId());
			pst.setDate(2, orders.getTransactionDate());
			pst.setDouble(3, orders.getTotalAmount());
			pst.setString(4, orders.getHomeDelivery());
			

			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
public Orders getOrders(int transactionId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Orders orders =null;
	final String SELECT_QUERY = "select * from orders where transactionId = ? ";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, transactionId);
		rst = pst.executeQuery();
		if(rst.next()){
			 orders=new Orders();
			 orders.setTransactionDate(rst.getDate(1));
			 orders.setTotalAmount(rst.getDouble(2));
			 orders.setHomeDelivery(rst.getString(3));	 

		System.out.println(orders);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return orders;
	}
	public List<Orders> getAllOrders(){

		List<Orders> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from orders ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Orders orders=new Orders();
			orders.setTransactionDate(rst.getDate(1));
			orders.setTotalAmount(rst.getDouble(2));
			orders.setHomeDelivery(rst.getString(3));
			
			
			list.add(orders);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int delete(int transactionId) {
		final String DELETE_QUERY="delete from Orders where transactionId=?";
		PreparedStatement pst = null;
		
		int status=0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(DELETE_QUERY);
			pst.setInt(1, transactionId);
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public void editEntry (int transactionId , Date transactionDate, Double totalAmount, String homeDelivery) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    Orders orders = null;
	    
	    
	    final String UPDATE_QUERY = "update Orders set transactionId = ?, transactionDate = ? , totalAmount = ?, homeDelivery = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setInt(1, transactionId);
		    pst.setDate(2, transactionDate);
		    pst.setDouble(3, totalAmount);
		    pst.setString(4, homeDelivery);

		    rst =pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
