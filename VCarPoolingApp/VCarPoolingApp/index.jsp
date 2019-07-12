<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VCarPooling - welcome</title>


<link href="/VCarPoolingApp/CSS/styles.css" rel="stylesheet" type="text/css">
<script src="/VCarpoolingApp/JS/validate.js" type="text/javascript"></script>

</head>
<body>

	<form method="post" action="/VCarPoolingApp/FindCarsControllerServlet">
		<div class="box">
			<h1>VCarPool - Pool Your Car</h1>
			
			<input type="text" name="source" required="required" id="source"
				placeholder="enter source" class="email" /> 
				<input id="destination"
				type="text" name="destination" required="required"
				placeholder="enter your destination" class="email" />
				<input type="time" name="time" required="required" id="time"  class="email" placeholder="enter departure time"/>
				 <center><input type="submit" value="Find Cars" class="btn"></center>
			<!-- End Btn -->


			<!-- End Btn2 -->

		</div>
		<!-- End Box -->

	</form>
	


</body>
</html>