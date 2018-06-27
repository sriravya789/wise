package com.mi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.dbutility.DBConnection;
import com.mi.dto.Cart;
import com.mi.dto.Customer;
import com.mi.dto.Orders;
import com.mi.dto.Pharmacy;
import com.mi.dto.Stock;

public class CartDAO {
	public int add(Cart cart){
		final String INSERT_QUERY="insert into cart(quantity,stockId1,price,ordersTransactionId,customerId) values(?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, cart.getQuantity());
			pst.setInt(2, cart.getStockId().getId());
			pst.setDouble(3, cart.getPrice());
			pst.setInt(4, cart.getTransactionId().getTransactionId());
			pst.setInt(5, cart.getId().getId());

			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
public Cart getCart(int orderTransactionId,int customerId){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Cart cart=null;
	final String SELECT_QUERY = "select * from cart where orderTransactionId = ? and customerId = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, orderTransactionId);
		pst.setInt(2, customerId);
		rst = pst.executeQuery();
		if(rst.next()){
			 cart=new Cart();
			 cart.setQuantity(rst.getInt(1));
			 Stock stock = new Stock();
			 stock.setId(rst.getInt(2));
			 cart.setStockId(stock);

			 cart.setPrice(rst.getDouble(3));
			 
			 

		System.out.println(cart);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return cart;
	}
	public List<Cart> getAllCarts(){

		List<Cart> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from cart ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Cart cart=new Cart();
			cart.setQuantity(rst.getInt(1));
			
			Stock stock = new Stock();
			stock.setId(rst.getInt(2));
			cart.setStockId(stock);
			
			cart.setPrice(rst.getDouble(3));
			
			Orders orders = new Orders();
			orders.setTransactionId(rst.getInt(4));
			cart.setTransactionId(orders);
			
						
			Customer customer = new Customer();
			customer.setId(rst.getInt(5));
			cart.setId(customer);
			
			
			
			list.add(cart);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	/*public int delete(int id) {
		final String DELETE_QUERY="delete from Cart where id=?";
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
	}*/
	public void editEntry (int quantity, int stockId, double price, int ordersTransactionId, int customerId) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    Cart cart = null;
	    
	    
	    final String UPDATE_QUERY = "update Customer set quantity = ?, stockId = ? ,price = ?,ordersTransactionId = ?,customerId = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setInt(1, quantity);
		    pst.setInt(2, stockId);
		    pst.setDouble(3, price);
		    pst.setInt(4, ordersTransactionId);
		    pst.setInt(5, customerId);
		    

		    rst = pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
