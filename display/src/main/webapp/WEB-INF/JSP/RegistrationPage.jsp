<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/styles-web.css">
</head>
<body>
	<h1>Registration Form</h1>
	<form id="registrationForm" action="registrationSuccessHash" method="post" onsubmit="event.preventDefault(); submitForm();">
    <label for="name">Name:</label> <br> 
    <input type="text" id="name" name="name" required> <br> 
    <label for="age">DOB:</label><br> 
    <input type="date" id="age" name="age" required><br>
    <input type="submit" value="Submit">
</form>

<script type="text/javascript">
//How to send html data to server side via AJAX 13-03-2024

/* document.getElementById('registrationForm').addEventListener('submit', function(event) {
	//console.log("Submit button clicked but navigation stopped");
	event.preventDefault(); // Prevent the form from submitting normally
	fetch('registrationSuccess', {
		method: 'POST',
		body: new FormData(event.target)
	})
	.then(response => response.json())
	.then(data => {
		alert('Data saved successfully');
		event.target.reset();
	})
	.catch(error => console.error('Error:', error));
}); */


//How to make request valid (Hash)
function submitForm(){
	alert("inside submitForm");
	const name = document.getElementById('name').value;
	const age = document.getElementById('age').value;
	const data = {name: name, age: age};
	const dataStr = JSON.stringify(data);
	const hash = CryptoJS.SHA256(dataStr).toString();
	alert(hash);
	fetch('registrationSuccessHash', {
		method: 'POST',
		headers: {
            'Content-Type': 'application/json'
        },		
		body: JSON.stringify({data: data, hash: hash})
	})
	.then(response => response.json())
	.then(data => {
		alert('Data saved successfully');
		document.getElementById('registrationForm').reset();
		console.log("data sent " + hash);
	});
}
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
<%@ include file="Footer.jsp"%>
</body>
</html>

