<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add New Bikes</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}
		h1 {
			text-align: center;
			color: #333;
			margin-top: 50px;
			margin-bottom: 30px;
		}
		form {
			margin: auto;
			width: 400px;
			background-color: #fff;
			padding: 20px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
			border-radius: 10px;
		}
		label {
			display: block;
			margin-bottom: 5px;
			color: #333;
		}
		input[type="text"] {
			display: block;
			width: 100%;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 4px;
			font-size: 16px;
			margin-bottom: 20px;
			box-sizing: border-box;
		}
		input[type="submit"] {
			display: block;
			background-color: #a8aca8;
			color: #fff;
			padding: 10px;
			font-size: 16px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			transition: background-color 0.3s;
		}
		input[type="submit"]:hover {
			background-color: #9faa9f;
		}
	</style>
</head>
<body>
	<h1>Add New Bikes</h1>

	<form:form method="post" action="editsave">

		<label for="bikeID">Bike ID:</label>
		<form:input path="bikeID" id="bikeID" />

		<label for="ownerName">Owner Name:</label>
		<form:input path="ownerName" id="ownerName" />

		<label for="ownerContact">Owner Contact:</label>
		<form:input path="ownerContact" id="ownerContact" />

		<label for="model">Model:</label>
		<form:input path="model" id="model" />

		<label for="serviceDetails">Service Details:</label>
		<form:input path="serviceDetails" id="serviceDetails" />

		<label for="serviceManagerID">Service Manager ID:</label>
		<form:input path="serviceManagerID" id="serviceManagerID" />

		<label for="status">Status:</label>
		<form:input path="status" id="status" />

		<input type="submit" value="Save" />

	</form:form>
</body>
</html>
