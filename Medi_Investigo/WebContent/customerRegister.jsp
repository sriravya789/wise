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
<body bgcolor = "#A3E4D7">
<center>
<h1>CUSTOMER REGISTRATION FORM</h1>

<form action="MiController" method="post">

		<p>
			<label for="CustomerId" class="floatLabel">CustomerId</label>
			<input id="Id" name="Id" type="text" placeholder= "CustomerId">
		</p>
		<p>
			<label for="CustomerName" class="floatLabel">CustomerName</label>
			<input id="Name" name="Name" type="text" placeholder = "CustomerName">
			
		</p>
		<p>
			<label for="Password" class="floatLabel">Password</label>
			<input id="Password" name="Password" type="password" placeholder = "Password">
			
		</p>
		<p>
			<label for="Gender" class="floatLabel">Gender</label>
			<input id="Gender" name="Gender" type="text" placeholder = "Gender">
			
		</p>
		
		<p>
			<label for="HouseNumber" class="floatLabel">HouseNumber</label>
			<input id="HNo" name="HNo" type="text" placeholder = "HouseNo">
			
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
			<input id="State" name="State" type="text" placeholder = "State">
	
		</p>
		
		<p>
			<label for="Pincode" class="floatLabel">Pincode</label>
			<input id="Pincode" name="Pincode" type="text" placeholder = "Pincode">
	
		</p>
	<p>
			<label for="PhoneNo" class="floatLabel">PhoneNo</label>
			<input id="PhoneNo" name="PhoneNo" type="text" placeholder = "PhoneNo">
	
		</p>
	
	<p>
			<label for="EmailId" class="floatLabel">EmailId</label>
			<input id="EmailId" name="EmailId" type="text" placeholder = "EmailId">
	
		</p>
		
		
		<p>
				<input type=hidden name="action"  value="customerRegister"/>
		
			<input type="submit" value="customerRegister" id="submit">
		</p>
	</form>
</center>
</body>

<%@include file = "footer.jsp" %>
</html>