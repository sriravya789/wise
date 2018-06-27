<%@include file ="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body background="./images/p.jpg">
<form action = "/action_page.php">
<div class = "imgcontainer">
<img src = "./images/p.jpg" width =1800px height = 10px alt = "Avatar" class = "Avatar">
</div>

</head>
<body bgcolor= "#BDC3C7">
<center>
<h1>CUSTOMER</h1>
<form action="#" method="post">

		<p>
			<label for="UserName" class="floatLabel">UserName</label>
			<input id="UserName" name="UserName" type="text" placeholder= "UserName">
		</p>
		<p>
			<label for="Password" class="floatLabel">Password</label>
			<input id="Password" name="Password" type="password" placeholder = "Password">
			
		</p>
		<p>
		<input type=hidden name="action"  value="customerLogin"/>
		
            <input type = "button" name = "s" value = "customerLogin"/>

		</p>
		
<input type = "button" onclick="location.href='customerRegister.jsp';"value = "REGISTER"/>
</form>

</center>
</body>
<%@include file = "footer.jsp" %>
</html>