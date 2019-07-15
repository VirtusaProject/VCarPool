<%@page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<h1>welcome home <%=session.getAttribute("userid") %></h1><br>
<h2 id="user"> </h2>
<div>
<form action="/VCarPoolingApp/LogoutControllerServlet"><input type="submit" value="logout"></form>
</div>

</body>
</body>
</html>