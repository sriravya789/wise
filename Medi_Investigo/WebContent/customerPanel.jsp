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
<center>

<form action="MiController" method="post">
<tr>Medicine Name</tr>
<input type = "text" name = "medic" placeholder = "MedicineName"/>
<br>
<tr>Pincode</tr>

<input type = "text" name = "pin" placeholder = "pincode"/>
<input type=hidden name="action"  value="search"/>
<input type = "submit" name = "s" value = "submit"/>

</form>

</center>
</body>
<%@include file = "footer.jsp" %>
</html>