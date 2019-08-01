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
	<table border="1" align="center">
	<tr><td>
	<label>Car Number</label></td><td><input type="text" readonly="readonly"  name="bCarNo" value=<%=cars.getRegNo() %> /></td></tr>
	<tr><td>
	<label>Car Name</label></td><td><input type="text" readonly="readonly"  id= "bCarName" value=<%=cars.getCarName() %> /></td></tr>
	<tr><td>
	<label>Source</label></td><td><input type="text" readonly="readonly"  id ="bCarSource" value=<%=cars.getSource() %> /></td></tr>
	<tr><td>	
	<label>Destination</label></td><td><input type="text" readonly="readonly"  id ="bCarDest" value=<%=cars.getDestination() %> /></td></tr>
	<tr><td>
	<label>Departure Time</label></td><td><input type="text" readonly="readonly" id="bCarTime" value=<%=cars.getDeptTime() %> /></td></tr>
	<tr><td>
	<label>Seats Selected</label></td><td><input type="text" readonly="readonly"  name="bSeatsAvailable" value=<%=session.getAttribute("seats")%> /></td></tr>
	<tr><td>
	<label>Fare to be paid</label></td><td><input type="text" readonly="readonly"  id="fare" value="40" /></td></tr>
	<tr align="center"> <td align="center" colspan="2">
	<input type="submit" value="Confirm" /></td></tr>
	</table>
	</form>
</body>
</html>