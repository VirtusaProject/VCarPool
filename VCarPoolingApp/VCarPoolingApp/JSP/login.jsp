<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>VCarPool - Signin</title>
<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet"
	type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript">
	
</script>

<%	
	String message="";
	Object obj=request.getAttribute("message");
	if(obj!=null)
	 message=(String)request.getAttribute("message");
	
%>

</head>
<body>
	<form method="post" action="/VCarPoolingApp/LoginControllerServlet">
		<div class="box">
			<h1>Login to VCarPool</h1>
			<h2 style="color:red;"><%=message %></h2>

			<input type="text" name="userid" required="required" id="userid"
				placeholder="enter user ID" class="email" /> <input id="password"
				type="password" name="password" required="required"
				placeholder="enter your password" class="email" /> <input
				type="submit" value="Sign in" class="btn">
			<!-- End Btn -->

			<a href="/VCarPoolingApp/JSP/register.jsp"><div id="btn2">Sign Up</div></a>
			<!-- End Btn2 -->

		</div>
		<!-- End Box -->

	</form>

	<p>
		Forgot your password? <u style="color: #f1c40f;">Click Here!</u>
	</p>

</body>
</html>