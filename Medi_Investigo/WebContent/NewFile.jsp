<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@ page import = "com.ts.dbutility.DBConnection" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.ts.dto.Resident" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Example of Bootstrap 3 Vertical Form Layout</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0} 
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}
</style>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
    box-sizing: border-box;
}

body {
    margin: 0;
    font-family: "Comic Sans MS", cursive, sans-serif;
    font-size: 25px;
    
}

.container {
    position: relative;
    max-width: 2000px;
    margin: 0 auto;
}

.container img {vertical-align: middle;}

.container .content {
    position: absolute;
    top: 0;
    /*background: rgba(0, 0, 0, 0.5); /* Black background with transparency */
    color: #f1f1f1;
    width: 100%;
    padding: 20px;
}
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: "Comic Sans MS", cursive, sans-serif;
}



button {
 
  outline: 0;
  display: inline-block;
  border-radius:20%;
  color: white;
  background-color: #220066;
  text-align: center;
  cursor: pointer;
  
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}

</style>
</head>
<body>


<div class="container">
  <img src="profile1.jpg" alt="Notebook" style="width:100%;">
  <div class="content">
  <% 
Resident resident = (Resident)request.getAttribute("resident"); 
   session.setAttribute("flatNo",resident.getFlatNo());
   
   %>
   <% //String flatNo = request.getParameter("flatNo");
   //session.setAttribute("flatNo",flatNo);
   %>
<div class = "card">
<center>
<fieldset>
<h1 style="text-decoration:underline">Profile</h1>


			<b>FlatNo</b>  : ${resident.flatNo}<br>
			<b>UserName</b> : ${resident.userName}<br>
			<b>No Of Occupants</b> : ${resident.familySize}<br>
			<b>Occupant Contact No</b> : ${resident.contactNo}<br>
			<b>Email </b>: ${resident.email}<br>
			<b>TypeOfResident</b>: ${resident.status}<br>
			<b>Occupation</b> : ${resident.occupation}<br>
			<b>Native </b>	: ${resident.place}<br>
			<b>OwnerContactNo</b> : ${resident.ownerContactNo}<br>
</fieldset>	
</center>			


<!-- <h2>Animated Modal with Header and Footer</h2>-->

<!-- Trigger/Open The Modal -->
<center><button id="myBtn">Check Dues</button></center>
</div>


</div>
</div>
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>Bill Details</h2>
    </div>
    <div class="modal-body">
      <!--<p>Some text in the Modal Body</p>
      <p>Some other text...</p>-->
 <center>
<fieldset>
<%
//String flatNo = request.getAttribute("flatNo").toString();
String flatNo = session.getAttribute("flatNo").toString();
//int no=Integer.parseInt(flatNo);
//System.out.println(no);
PreparedStatement pst = null;
//session.setAttribute("flatNo", flatNo);
//int sumcount=0;
try(Connection conn = DBConnection.getConnection();) {
final String QUERY = "select * from Bills where flatNo =" + flatNo + "";
pst = conn.prepareStatement(QUERY);
//pst.setInt(1, no);
ResultSet rs = pst.executeQuery(QUERY);

while(rs.next()){
%>

<b>MAINTENANCE</b>:<%=rs.getString(2) %><br>
<b>ELECTRICITY:</b><%=rs.getString(3)%><br>
<b>WATER:</b><%=rs.getString(4) %><br>
<!-- <div class="form-group row">
            <label for="maintenance" class="col-sm-2 col-form-label">MAINTENANCE</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" id="maintenance" name = "maintenance" value=<%=rs.getString(2) %>>
</div>
</div>
<div class="form-group row">
            <label for="electricity" class="col-sm-2 col-form-label">ELECTRICITY</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" id="electricity" name = "electricity" value=<%=rs.getString(3) %>>
</div>
</div>
<div class="form-group row">
            <label for="water" class="col-sm-2 col-form-label">WATER</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" id="water" name = "water" value=<%=rs.getString(4) %>>
</div>
</div>-->
<%
}

}

catch(SQLException e){}
%>
</fieldset>
</center>
    </div>
    <div class="modal-footer">
      <!--<h3></h3>-->
    </div>
  </div>

</div>


<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>