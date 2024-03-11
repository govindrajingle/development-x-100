<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD | ADD DETAILS</title>
<link rel="icon" href="/favicons/icons8-anime-16.png" type="image/png">
<link rel="stylesheet" href="/css/styles-web.css">
</head>
<body>
	<h1>Registration Form</h1>
	<form action="register" method="post">
		<label for="name">Name:</label><br> <input type="text" id="name"
			name="name"><br> <label for="age">Age:</label><br>
		<input type="date" id="age" name="age"><br> <input
			type="submit" value="Submit">
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>

