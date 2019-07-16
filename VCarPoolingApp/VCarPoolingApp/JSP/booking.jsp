<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.*"  %>
   <%@page import="com.virtusa.carpool.model.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>booking</title>
<%
Object obj= session.getAttribute("bookCars");
Car cars=(Car)obj;

%>
</head>
<body>
	<form action="/VCarPoolingApp/ConfirmControllerServlet" method="post">
	<input type="text" readonly="readonly"  name="bCarNo" value=<%=cars.getRegNo() %> />
	<input type="text" readonly="readonly"  id= "bCarName" value=<%=cars.getCarName() %> />
	<input type="text" readonly="readonly"  id ="bCarSource" value=<%=cars.getSource() %> />
	<input type="text" readonly="readonly"  id ="bCarDest" value=<%=cars.getDestination() %> />
	<input type="text" readonly="readonly" id="bCarTime" value=<%=cars.getDeptTime() %> />
	<input type="text" readonly="readonly"  name="bSeatsAvailable" value=<%=session.getAttribute("seats")%>/>
	<input type="text" readonly="readonly"  id="fare" value="40" />
	<input type="submit" value="Confirm" />
	</form>
</body>
</html>