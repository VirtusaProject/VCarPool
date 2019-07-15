<%@page isELIgnored="false" session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.virtusa.carpool.model.*" %>
<!DOCTYPE html>
<html>
<head>

<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet" type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript"> </script>

<%
	if(session.getAttribute("userid")==null) {
		response.sendRedirect("../JSP/login.jsp");
		
	} else;  
	
	
%>

<meta charset="ISO-8859-1">

<title>Home - <%=session.getAttribute("userid")   %></title>

</head>
<body>
<body>
<h1><%=session.getAttribute("userid")%>, <%=session.getAttribute("username")%>, <%=session.getAttribute("useremail")%>, <%=session.getAttribute("usertype")%> </h1><br>
<h2 id="user"> </h2>
<div>
<form action="/VCarPoolingApp/LogoutControllerServlet"><input type="submit" value="logout"></form>
</div>

</body>
</body>
</html>