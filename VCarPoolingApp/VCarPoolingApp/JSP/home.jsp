<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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