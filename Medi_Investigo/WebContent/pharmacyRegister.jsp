<%@include file = "header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body background="./images/p.jpg">
<div class = "imgcontainer">
<img src = "./images/p.jpg" width =1800px height = 10px alt = "Avatar" class = "Avatar">
</div>

</head>
<body bgcolor = "#D5F5E3">
<center>
<h1>PHARMACY REGISTRATION FORM</h1>
<form action="MiController" method="post">

		<p>
			<label for="Id" class="floatLabel">PharmacyId</label>
			<input id="Id" name="Id" type="text" placeholder= "Id">
		</p>
		<p>
			<label for="Name" class="floatLabel">PharmacyName</label>
			<input id="Name" name="Name" type="text" placeholder = "PharmacyName">
			
		</p>
		
		<p>
			<label for="Password" class="floatLabel">Password</label>
			<input id="Password" name="Password" type="password" placeholder = "Password">
			
		</p>
		
		<p>
			<label for="Certificate" class="floatLabel">Certificate</label>
			<input id="Certificate" name="Certificate" type="text" placeholder = "Certificate">
			
		</p>
		
		<p>
			<label for="Street" class="floatLabel">Street</label>
			<input id="Street" name="Street" type="text" placeholder = "Street">
		</p>
		
		<p>
			<label for="Village" class="floatLabel">Village</label>
			<input id="Village" name="Village" type="text" placeholder = "Village">
			
		</p>
		
		<p>
			<label for="District" class="floatLabel">District</label>
			<input id="District" name="District" type="text" placeholder = "District">

		</p>
		
		<p>
			<label for="State" class="floatLabel">State</label>
			<input id="State" name="State" type="text" placeholder = "Street">
	
		</p>
		
		<p>
			<label for="Pincode" class="floatLabel">Pincode</label>
			<input id="Pincode" name="Pincode" type="text" placeholder = "Pincode">
	
		</p>
	<p>
			<label for="Status" class="floatLabel">Status</label>
			<input id="Status" name="Status" type="text" placeholder = "Status">
	
		</p>
	
		
		
		<p>
			<input type=hidden name="action"  value="pharmacyRegister"/>
		
			<input type="submit" value="pharmacyRegister" id="submit">
		</p>
	</form>

</center>
</body>
<%@include file = "footer.jsp" %>
</html>