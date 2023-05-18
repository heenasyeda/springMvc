<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add New Branch</title>
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
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<h1>Add New Product</h1>
	<form:form method="POST" action="/BikeServiceManagements/savebranch">
		<table>
			<tr>
				<td><label for="name">Branch Name:</label></td>
				<td><form:input type="text" path="name" id="name" /></td>
			</tr>
			<tr>
				<td><label for="address">Address:</label></td>
				<td><form:input type="text" path="address" id="address" /></td>
			</tr>
			<tr>
				<td><label for="contact">Contact:</label></td>
				<td><form:input type="text" path="contact" id="contact" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>






