<%@page isELIgnored="false" session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.carpool.model.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet" type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript"> </script>

<%
String testString="";
	if(session.getAttribute("userid")==null) {
		response.sendRedirect("../JSP/login.jsp");
		
		
	} else {
		Object obj=session.getAttribute("userid");
		testString=(String)obj;
	}
	
	
%>

<meta charset="ISO-8859-1">

<title>Home - <%=session.getAttribute("userid")   %></title>

</head>
<body>
<body>

<div class="topnav">
  <a href="#home" class="active">Logo</a>
  <!-- Navigation links (hidden by default) -->
  <div id="myLinks">
    <a href="/VCarPoolingApp/index.jsp">Home</a>
    <a href="/VCarPoolingApp/JSP/logout.jsp">Logout</a>
    
  </div>
  <!-- "Hamburger menu" / "Bar icon" to toggle the navigation links -->
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>

</body>
</body>
</html>