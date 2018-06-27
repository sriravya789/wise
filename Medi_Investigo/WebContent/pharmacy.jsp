<%@include file ="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>

<h1>PHARMACY</h1>
<form action="MiController" method="post">

		<p>
			<input id="UserName" name="uname" type="text" placeholder= "UserName">
		</p>
		<p>
			<input id="Password" name="pwd" type="password" placeholder = "Password">
			
		</p>
		<p>
			<input type=hidden name="action"  value="pharmacyLogin"/>
		
            <input type = "submit" name = "s" value = "login"/>
            


		</p>
		

</form>
<p>
<a href='pharmacyRegister.jsp' >Register</a>
</p>
</center>

</body>
<%@include file ="footer.jsp" %>
</html>
