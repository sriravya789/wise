<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"	prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border=1>
<tr>
<th>MedicineName</th>
<th>Generic</th>
<th>Brand</th>
<th>Quantity</th>
<th>Price</th>
<th>Manufacturer</th>

<th>Pharmacy Location
</th>
    
 
 <c:forEach items = "${stockList}" var = "stock">
 
 <tr>
				<td>${stock.medicineName }</td>
				<td>${stock.generic }</td>
				<td>${stock.brand }</td>
				<td>${stock.quantity }</td>
				<td>${stock.price }</td>
				<td>${stock.manufacturer }</td>
				<td>${stock.pharmacyId.name }<br>
				${stock.pharmacyId.street }<br>
				${stock.pharmacyId.village }<br>
				${stock.pharmacyId.district }<br>
		    	${stock.pharmacyId.state }<br>
				${stock.pharmacyId.pincode }</td>
				
			</tr>
 
 
 </c:forEach>
 
 </table>
</center>
</body>
</html>