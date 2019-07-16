<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet" type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript"></script>
<title>Add Car</title>

</head>
<body>
	



	<div class="login-card">
		
		<form action="CarServ" method="post">
		<div class="box">
		<h2>
		hello
		<%=session.getAttribute("userid")%>
		add your car
	</h2>
			<input type="text" name="regno"
				placeholder="Enter Car Registration No" class="email" > <input type="text"
				name="carname" placeholder="Enter Car Name" class="email" > <input
				type="text" name="seat" placeholder="Enter No of Seats" class="email" > <input
				type="text" name="source" placeholder="Enter Source" class="email"> <input
				type="text" name="destination" placeholder="Enter destination" class="email" >
				<input
				type="time" name="time" id="time"  required / class="email"> <br>
			<input type="submit" name="login" 
				value="submit" class="btn">
				</div>
		</form>

	</div>
</body>

</html>

</body>
</html>