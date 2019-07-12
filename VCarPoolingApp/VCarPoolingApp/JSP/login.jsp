<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
Object obj= request.getAttribute("message");
String message="";
if(obj!=null)
	 message=(String)obj;
%>

<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet"
	type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript">
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VCarPool - login</title>
</head>
<body>

<form method="post" action="/VCarPoolingApp/LoginControllerServlet" >
		<div class="box">
			<h1>Sign in - VCarPool</h1>
			<h3 style="color:red;"><%=message%></h3>
	
			<input type="text" name="userid" id="userid" required="required"
				placeholder="enter user id" class="email" />
				<input type="password" name="password" id="password" required="required" placeholder="enter your password"
				 class="email" />
				 <input type="submit" value="Sign in" class="btn" onclick="return regValidate(password,password1);">
				 <a href="/VCarPoolingApp/JSP/register.jsp"><div id="btn2">Sign Up</div></a> <!-- End Btn2 -->
  
</div> <!-- End Box -->
  
</form>

<p>Forgot your password? <u style="color:#f1c40f;">Click Here!</u></p>
				 



</body>
</html>