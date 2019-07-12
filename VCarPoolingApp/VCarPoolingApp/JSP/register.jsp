<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VCarPool - signUp</title>
<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet"
	type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript">
	
</script>

<%
String message="";
Object obj=request.getAttribute("regMessage");
if(obj!=null)
 message=(String)request.getAttribute("regMessage");

%>
</head>
<body>
<form method="post" action="/VCarPoolingApp/RegControllerServlet" >
		<div class="box">
			<h1>Sign up - VCarPool</h1>
			<h5 style="color:red;"><%=message %></h5>
	
			<input type="text" name="username" id="username" required="required"
				placeholder="enter user name" class="email" />
				
				<input type="email" name="email" id="email" required="required"
				placeholder="enter email" class="email" />
				
				
			
				
				 <input type="password" name="password" id="password" required="required" placeholder="enter your password"
				 class="email" /> 
				 <input type="password" name="password1" id="password1" required="required" placeholder="re-enter your password"
				 class="email" />  <p id="error" style="color:red"></p>
				 
				 
			   <center><input type="radio" name="type" value="rider" checked="checked">Rider
				<input type="radio" name="type" value="provider" > provider <br> </center>
				
				
				<input type="submit" value="Sign up" class="btn" onclick="return regValidate(password,password1);">
				

</body>
</html>