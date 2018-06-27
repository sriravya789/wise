package com.mi.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mi.dao.CustomerDAO;
import com.mi.dao.OrdersDAO;
import com.mi.dao.PharmacyDAO;
import com.mi.dao.StockDAO;
import com.mi.dto.Admin;
import com.mi.dto.Customer;
import com.mi.dto.Orders;
import com.mi.dto.Pharmacy;
import com.mi.dto.Stock;


@WebServlet("/MiController")
public class MiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String action = request.getParameter("action");
    	
    	if("addStock".equalsIgnoreCase(action)) {
		response.sendRedirect("addStock.jsp");	return;
		}
    	
    	if("viewCustomers".equalsIgnoreCase(action)) {
			CustomerDAO dao=new CustomerDAO();
			
			List<Customer> customerList=dao.getAllCustomers();
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("./viewCustomer.jsp");
			request.setAttribute("customerList", customerList);
			dispatcher.forward(request, response);
			return;
		}
    	if("viewPharmacies".equalsIgnoreCase(action)) {
			PharmacyDAO dao=new PharmacyDAO();
		
			List<Pharmacy> pharmacyList=dao.getAllPharmacies();
		
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewPharmacy.jsp");
			request.setAttribute("pharmacyList", pharmacyList);
			dispatcher.forward(request, response);
			return;
		}

	
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if ("adminLogin".equalsIgnoreCase(action)) {
			loginAsAdmin(request).forward(request,response);
			return;
		}
		if ("pharmacyLogin".equalsIgnoreCase(action)) {
			loginAsPharmacy(request).forward(request,response);
			return;
		}
		if ("customerLogin".equalsIgnoreCase(action)) {
			loginAsCustomer(request).forward(request,response);
			return;
		}
		if ("pharmacyRegister".equalsIgnoreCase(action)) {
			
			registerAsPharmacy(request).forward(request,response);
			return;
		}
		if("customerRegister".equalsIgnoreCase(action)) {
			registerAsCustomer(request).forward(request,response);
			return;
		}
			if("viewPharmacies".equalsIgnoreCase(action)) {
			PharmacyDAO dao=new PharmacyDAO();
		
			List<Pharmacy> pharmacyList=dao.getAllPharmacies();
		
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewPharmacy.jsp");
			request.setAttribute("pharmacyList", pharmacyList);
			dispatcher.forward(request, response);
		}
		if("viewOrders".equalsIgnoreCase(action)) {
			OrdersDAO dao=new OrdersDAO();
			
			List<Orders> ordersList=dao.getAllOrders();
		
			RequestDispatcher dispatcher=request.getRequestDispatcher("");
			request.setAttribute("ordersList", ordersList);
			dispatcher.forward(request, response);
			return;
		}
		if("addStock".equalsIgnoreCase(action)) {
			addStock(request).forward(request,response);
			return;
		}
		
		if("deleteStock".equalsIgnoreCase(action)) {
			deleteStock(request).forward(request,response);
			return;
		}
		if("search".equalsIgnoreCase(action)) {
			searchMedicine(request).forward(request,response);
		}
		
	}
		


		private RequestDispatcher searchMedicine(HttpServletRequest request) {
		// TODO Auto-generated method stub
			HttpSession session=request.getSession();
			//PrintWriter out=response.getWriter();

			String medicineName=request.getParameter("medic");

			//Customer customer=(Customer)session.getAttribute("loggedUser");

			//int pin=customer.getPincode();
			
			int pin=Integer.parseInt(request.getParameter("pin"));
			
			CustomerDAO customerDao = new CustomerDAO();
			List<Stock> stockList=customerDao.searchMedicine(pin, medicineName);
			
			request.setAttribute("stockList", stockList);
			System.out.println("stock is:"+stockList.size());
			System.out.println("stock :"+stockList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("searchMedicine.jsp");
			return dispatcher;
	 }


		private RequestDispatcher deleteStock(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


		private RequestDispatcher addStock(HttpServletRequest request) {
			String medicineName=request.getParameter("medicineName");
			String generic=request.getParameter("generic");
			String brand=request.getParameter("brand");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			Double price = Double.parseDouble(request.getParameter("price"));
			String manufacturer = request.getParameter("manufacturer");
	
			HttpSession session=request.getSession(false);
			Pharmacy pharmacy=(Pharmacy)session.getAttribute("loggedUser");
			Stock stock=new Stock();
			stock.setMedicineName(medicineName);
			stock.setGeneric(generic);
			stock.setBrand(brand);
			stock.setQuantity(quantity);
			stock.setPrice(price);
			stock.setManufacturer(manufacturer);
			RequestDispatcher dispatcher = null;
			
			StockDAO stockDAO=new StockDAO();
			if(stockDAO.add(stock)!=0){
	   		request.setAttribute("regStatus", "Registration Success");
		    dispatcher=request.getRequestDispatcher("homePage.jsp");
			}

			return dispatcher;
		}			



	private RequestDispatcher registerAsCustomer(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String hNo=request.getParameter("hNo");
		String street=request.getParameter("street");
		String village=request.getParameter("village");
		String district=request.getParameter("district");
		String state=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		int phoneNo=Integer.parseInt(request.getParameter("phoneNo"));
		String emailId=request.getParameter("emailId");

		Customer customer=new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setGender(gender);
		customer.sethNo(hNo);
		customer.setStreet(street);
		customer.setVillage(village);
        customer.setDistrict(district);
		customer.setState(state);
		customer.setPincode(pincode);
		customer.setPhoneNo(phoneNo);
		customer.setEmailId(emailId);
        
		RequestDispatcher dispatcher=null;
		System.out.println(customer);
		CustomerDAO customerDAO=new CustomerDAO();
		if(customerDAO.add(customer)!=0){
   		request.setAttribute("regStatus", "Registration Success");
	    dispatcher=request.getRequestDispatcher("homePage.jsp");
		}

		return dispatcher;
	}


	private RequestDispatcher registerAsPharmacy(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String street=request.getParameter("street");
		String village=request.getParameter("village");
		String district=request.getParameter("district");
		String state=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String status=request.getParameter("status");

		Pharmacy pharmacy=new Pharmacy();
		pharmacy.setName(name);
		pharmacy.setPassword(password);
		pharmacy.setStreet(street);
		pharmacy.setVillage(village);
        pharmacy.setDistrict(district);
		pharmacy.setState(state);
		pharmacy.setPincode(pincode);
		pharmacy.setStatus(status);
        
		RequestDispatcher dispatcher=null;
		System.out.println(pharmacy);
		PharmacyDAO pharmacyDAO=new PharmacyDAO();
		if(pharmacyDAO.add(pharmacy)!=0){
   		request.setAttribute("regStatus", "Registration Success");
	    dispatcher=request.getRequestDispatcher("homePage.jsp");
		}

		return dispatcher;
	}


	private RequestDispatcher loginAsAdmin(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String Id=request.getParameter("uid");
		String password=request.getParameter("pwd");
		RequestDispatcher dispatcher=null;
		
		if(Id.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", Id);
			
			dispatcher=request.getRequestDispatcher("adminPanel.jsp");	
		}else
		{
		    dispatcher=request.getRequestDispatcher("homePage.jsp");	
		}			
		return dispatcher;
		
	}


	private RequestDispatcher loginAsPharmacy(HttpServletRequest request) {
		// TODO Auto-generated method stub

		int id=Integer.parseInt(request.getParameter("uname"));
		String password=request.getParameter("pwd");
		RequestDispatcher dispatcher=null;

		PharmacyDAO pharmacyDao = new PharmacyDAO();
		System.out.println("uib asdkfj");
		Pharmacy pharmacy=pharmacyDao.getPharmacy(id, password);
		System.out.println("Inside servlet:"+pharmacy);
		if(pharmacy !=null){
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", pharmacy);

		    dispatcher=request.getRequestDispatcher("pharmacyPanel.jsp");	
						
		}else{
		   dispatcher=request.getRequestDispatcher("homePage.jsp");
					
	    }
		return dispatcher;
		
	}


	private RequestDispatcher loginAsCustomer(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("pwd");
		RequestDispatcher dispatcher=null;

		CustomerDAO customerDao = new CustomerDAO();
		Customer customer=customerDao.getCustomer(id, password);
		System.out.println("Inside servlet:"+customer);
		if(customer !=null){
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", id);
		

		    dispatcher=request.getRequestDispatcher("customerPanel.jsp");	
						
		}else{
		   dispatcher=request.getRequestDispatcher("homePage.jsp");
					
	    }
		return dispatcher;
		
		
	}
}
