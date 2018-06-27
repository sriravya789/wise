package com.mi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.dbutility.DBConnection;
import com.mi.dto.Customer;
import com.mi.dto.FeedBack;
import com.mi.dto.Orders;
import com.mi.dto.Stock;

public class FeedbackDAO {
	public int add(FeedBack feedback){
		final String INSERT_QUERY="insert into stock(transactionId,feedback) values(?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, feedback.getTransactionId().getTransactionId());
			pst.setString(2, feedback.getFeedback());
						
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
public FeedBack getFeedBack(int transactionId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		FeedBack feedback=null;
	final String SELECT_QUERY = "select feedback from feedback where transactionId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		
		pst.setInt(1, transactionId);
		rst = pst.executeQuery();
		if(rst.next()){
			 feedback=new FeedBack();
			 feedback.setFeedback(rst.getString(1));
			 			 

		System.out.println(feedback);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return feedback;
	}
	public List<FeedBack> getAllFeedBack(){

		List<FeedBack> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from feedback ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			FeedBack feedback=new FeedBack();
			Orders orders = new Orders();
			orders.setTransactionId(rst.getInt(1));
			feedback.setTransactionId(orders);
			
			feedback.setFeedback(rst.getString(2));
			
			list.add(feedback);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int delete(int ordersTransactionId) {
		final String DELETE_QUERY="delete from Feedback where OrdersTransactionId=?";
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
	public void editEntry (int ordersTransactionId, String feedback) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    FeedBack feedback1 = null;
	    
	    
	    final String UPDATE_QUERY = "update FeedBack set ordersTransactionId = ?, feedback = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setInt(1, ordersTransactionId);
		    pst.setString(2, feedback);
		    

		    rst = pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
