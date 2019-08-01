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
				placeholder="enter user name" class="email"  pattern="[A-Za-z]{6,}" title="username should contain altleast 6 characters"/>
				
				<input type="email" name="email" id="email" required="required"
				placeholder="enter email" class="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="please follow the format: characters followed by an @ sign, followed by more characters, and then a '.'"/>
				
				
			
				
				 <input type="password" name="password" id="password" required="required" placeholder="enter your password"
				 class="email"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/> 
				 <input type="password" name="password1" id="password1" required="required" placeholder="re-enter your password"
				 class="email"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/>  <p id="error" style="color:red"></p>
				 
				 
			   <center><input type="radio" name="type" value="rider" checked="checked">Rider
				<input type="radio" name="type" value="provider" > provider <br> </center>
				
				
				<input type="submit" value="Sign up" class="btn" onclick="return regValidate(password,password1);">
				

</body>
</html>