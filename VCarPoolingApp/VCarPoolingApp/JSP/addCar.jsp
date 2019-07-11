<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
<%
	Cookie[] cookies= request.getCookies();
	int name=Integer.parseInt(cookies[1].getValue());
%>
</head>
<body>
<h2>hello <%=cookies[1].getValue() %>  add your car</h2>
</body>
</html>