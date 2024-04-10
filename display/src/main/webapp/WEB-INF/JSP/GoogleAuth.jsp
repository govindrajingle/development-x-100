<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/styles-web.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Google Code</title>
</head>
<body>
	<h1>Scan the qr code with google authenticator app</h1>
	<img class="center" id="qrcode" src="qrcode" alt="QR Code" height="200"
		width="200">
	<h1>Enter Your Code</h1>
	<form id="verifyCode" action="receivedAuthCode"
		onsubmit="event.preventDefault(); submitForm();">
		<label for="code">Code:</label><br> <input type="text" id="code"
			name="code"><br> <input type="submit" value="Submit">
	</form>

	<%@ include file="Footer.jsp"%>

	<script>
	function submitForm(){
	    const code = document.getElementById('code').value;
	    const formData = new FormData();
	    formData.append('code', code);

	    fetch('receivedAuthCode', {
	        method: 'POST',
	        body: formData
	    })
	    .then(response => response.json())
	    .then(data => {
	        if(data.message === "Logged in successfully") {
	            swal("Success", "Valid code");
	        } else {
	            swal("Error", "Incorrect code");
	        }
	        document.getElementById('verifyCode').reset();
	    })
	    .catch(error => {
	        console.error('There has been a problem with your fetch operation: ', error);
	        swal("Error", "There was an error processing your code. Please try again.");
	    });
	}
	</script>
</body>
</html>