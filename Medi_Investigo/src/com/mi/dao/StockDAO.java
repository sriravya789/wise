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

public class StockDAO {
	public int add(Stock stock){
		final String INSERT_QUERY="insert into stock(id,medicineName,generic,brand,quantity,price,manufacturer,pharmacyId) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, stock.getId());
			pst.setString(2, stock.getMedicineName());
			pst.setString(3, stock.getGeneric());
			pst.setString(4, stock.getBrand());
			pst.setInt(5, stock.getQuantity());
			pst.setDouble(6, stock.getPrice());
			pst.setString(7, stock.getManufacturer());
			pst.setInt(8, pharmacyId);

			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
public Stock getStock(int id){
		PreparedStatement pst = null;
		ResultSet rst = null;
		Stock stock=null;
	final String SELECT_QUERY = "select * from stock where id = ? ";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, id);
		rst = pst.executeQuery();
		if(rst.next()){
			 stock=new Stock();
			 stock.setMedicineName(rst.getString(1));
			 stock.setGeneric(rst.getString(2));
			 stock.setBrand(rst.getString(3));
			 stock.setQuantity(rst.getInt(4));
			 stock.setPrice(rst.getDouble(5));
			 stock.setManufacturer(rst.getString(6));
			 Pharmacy pharmacy = new Pharmacy();
			 pharmacy.setId(rst.getInt(7));
			 stock.setPharmacyId(pharmacy);

		System.out.println(stock);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return stock;
	}
	public List<Stock> getAllStock(){

		List<Stock> list=new ArrayList<>();
		
		PreparedStatement pst = null;
		ResultSet rst = null;
	final String SELECT_QUERY = "select * from stock ";
	try(Connection con = DBConnection.getConnection();){
		pst = con.prepareStatement(SELECT_QUERY);
		rst = pst.executeQuery();
		while(rst.next()){
			Stock stock=new Stock();
			stock.setMedicineName(rst.getString(1));
			stock.setGeneric(rst.getString(2));
			stock.setBrand(rst.getString(3));
			stock.setQuantity(rst.getInt(4));
			stock.setPrice(rst.getDouble(5));
			stock.setManufacturer(rst.getString(6));
			
			list.add(stock);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public int delete(int id) {
		final String DELETE_QUERY="delete from Stock where id=?";
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
	public void editEntry (String medicineName, String generic, String brand, int quantity, Double price, String manufacturer) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    Stock stock = null;
	    
	    
	    final String UPDATE_QUERY = "update Stock set medicineName = ?, generic = ? ,brand = ?,quantity = ?,price = ?,manufacturer = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setString(1, medicineName);
		    pst.setString(2, generic);
		    pst.setString(3, brand);
		    pst.setInt(4, quantity);
		    pst.setDouble(5, price);
		    pst.setString(6, manufacturer);

		    rst = pst.executeUpdate();
		    
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}
