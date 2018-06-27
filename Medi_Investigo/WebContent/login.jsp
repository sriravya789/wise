<%@include file = "header.jsp" %>
<body background="./images/p.jpg">
<form action = "/action_page.php">
<div class = "imgcontainer">
<img src = "./images/p.jpg" width =1800px height = 10px alt = "Avatar" class = "Avatar">
</div>

</form>
<center>
<h1>LoginForm</h1>
<form action="MiController" method="post">

		<p>
			<label for="UserName" class="floatLabel">UserName</label>
			<input id="UserName" name="uid" type="text" placeholder= "UserName">
		</p>
		<p>
			<label for="Password" class="floatLabel">Password</label>
			<input id="Password" name="pwd" type="password" placeholder = "Password">
			
		</p>
		<input type=hidden name="action"  value="adminLogin"/>
		<p>
            <input type = "submit" name = "s" value = "Login"/>
        </p>
</form>


</center>
<%@include file = "footer.jsp" %>
