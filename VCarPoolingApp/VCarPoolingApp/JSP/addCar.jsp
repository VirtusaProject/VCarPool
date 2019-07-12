<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>

</head>
<body>
	<h2>
		hello
		<%=session.getAttribute("userid")%>
		add your car
	</h2>



	<div class="login-card">
		<h1>ADD CAR</h1>
		<form action="CarServ" method="post">
			<input type="text" name="regno"
				placeholder="Enter Car Registration No"> <input type="text"
				name="carname" placeholder="Enter Car Name"> <input
				type="text" name="seat" placeholder="Enter No of Seats"> <input
				type="text" name="source" placeholder="Enter Source"> <input
				type="text" name="destination" placeholder="Enter destination">
				<input
				type="time" name="time" id="time"  required />
			<input type="submit" name="login" class="login login-submit"
				value="submit">
		</form>

	</div>
</body>

</html>

</body>
</html>