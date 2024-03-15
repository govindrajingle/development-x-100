
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/styles-web.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.min.js"></script>
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

    <button id="button" onclick="showData()">Show Data</button>
    
<script type="text/javascript">

function showData(){
	alert("button pressed");
	   $.ajax({
	       url: '/homepage/showUsers', // Corrected this line
	       type: 'GET',
	       success: function(response) {
	           // Assuming the response is a list of 'NameAndAge' objects
	           var table = "<table><tr><th>Name</th><th>Age</th></tr>";
	           $.each(response, function(index, item) {
	               table += "<tr><td>" + item.name + "</td><td>" + item.age + "</td></tr>";
	           });
	           table += "</table>";
	           // Append the table to a div or replace existing table
	           $('#dataDiv').html(table);
	       },
	       error: function(error) {
	           console.log(error);
	       }
	   });
}

//How to make request valid (Hash) 15-03-2024
function submitForm(){
	const name = document.getElementById('name').value;
	const age = document.getElementById('age').value;
	const data = {name: name, age: age};
	const dataStr = JSON.stringify(data);
	const hash = CryptoJS.SHA256(dataStr).toString();
	fetch('registrationSuccessHash', {
	    method: 'POST',
	    headers: {
	        'Content-Type': 'application/json'
	    },      
	    body: JSON.stringify({data: data, hash: hash})
	})
	.then(response => {
	    if (!response.ok) {
	        throw new Error('Network response was not ok');
	        location.reload();
	    }
	    return response.json();
	})
	.then(data => {
	    swal("Good job!", "Data saved successfully", "success");
	    document.getElementById('registrationForm').reset();
	})
	.catch(error => {
	    console.error('There has been a problem with your fetch operation:', error);
        swal("Error!", "Form data tampered!", "error");
        location.reload();
	});
}
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
</script>


<%@ include file="Footer.jsp"%>
</body>
</html>

