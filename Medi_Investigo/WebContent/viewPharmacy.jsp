<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<th>Certificate</th>
			<th>Street</th>
			<th>Village</th>
			<th>District</th>
			<th>State</th>
			<th>Pincode</th>
			<th>Status</th>
			
		</tr>
		<c:forEach items="${pharmacyList}" var="pharmacy">
			<tr>
				<td>${pharmacy.id }</td>
				<td>${pharmacy.name }</td>
				<td>${pharmacy.password }</td>
				<td>${pharmacy.certificate }</td>
				<td>${pharmacy.street }</td>
				<td>${pharmacy.village }</td>
				<td>${pharmacy.district }</td>
				<td>${pharmacy.state }</td>
				<td>${pharmacy.pincode }</td>
				<td>${pharmacy.status }</td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>