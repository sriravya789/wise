<%@include file = "header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "imgcontainer">
<img src = "./images/p.jpg" width =1800px height = 10px alt = "Avatar" class = "Avatar">
</div>

</head>
<body bgcolor = "#D5F5E3">
<center>
<h1>ADD STOCK</h1>
<form action="MiController" method="post">

		<p>
			<label for="MedicineName" class="floatLabel">MedicineName</label>
			<input id="MedicineName" name="MedicineName" type="text" placeholder= "MedicineName">
		</p>
		<p>
			<label for="Generic" class="floatLabel">Generic</label>
			<input id="Generic" name="Generic" type="text" placeholder = "Generic">
			
		</p>
		
		<p>
			<label for="Brand" class="floatLabel">Brand</label>
			<input id="Brand" name="Brand" type="text" placeholder = "Brand">
			
		</p>
		
		<p>
			<label for="Quantity" class="floatLabel">Quantity</label>
			<input id="Quantity" name="Quantity" type="text" placeholder = "Quantity">
			
		</p>
		<p>
			<label for="Price" class="floatLabel">Price</label>
			<input id="Price" name="Price" type="text" placeholder = "Price">
			
		</p>
		
		<p>
			<label for="Manufacturer" class="floatLabel">Manufacturer</label>
			<input id="Manufacturer" name="Manufacturer" type="text" placeholder = "Manufacturer">
		</p>
		
		<p>
				<input type=hidden name="action"  value="addStock"/>
		
			<input type="submit" value="addStock" id="submit">
		</p>
	</form>
	

</center>
</body>
</html>