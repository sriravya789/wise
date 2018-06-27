<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
		<tr>
		    <th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Gender</th>
			<th>HNo</th>
			<th>Street</th>
			<th>Village</th>
			<th>District</th>
			<th>State</th>
			<th>Pincode</th>
			<th>PhoneNo</th>
			<th>EmailId</th>
			
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.id }</td>
				<td>${customer.name }</td>
				<td>${customer.password }</td>
				<td>${customer.gender }</td>
				<td>${customer.hNo }</td>
				<td>${customer.street }</td>
				<td>${customer.village }</td>
				<td>${customer.district }</td>
				<td>${customer.state }</td>
				<td>${customer.pincode }</td>
		    	<td>${customer.phoneNo }</td>
				<td>${customer.emailId }</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>