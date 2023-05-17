<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
}

h1 {
	margin-top: 20px;
	margin-bottom: 30px;
	text-align: center;
}

table {
	width: 50%;
	margin: 0 auto;
}

td {
	padding: 10px;
	text-align: left;
}

input[type="text"] {
	width: 100%;
	padding: 6px 10px;
	border-radius: 4px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type="submit"] {
	padding: 8px 16px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<h1>Add New Service Manager</h1>

	<form:form method="post"
		action="/BikeServiceManagements/editsaveService">
		<table>
			<tr>
				<td>ServiceManagerID:</td>
				<td><form:input path="serviceManagerID" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<td>BranchID :</td>
				<td><form:input path="branchID" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
			<tr>
				<td><label for="role">Role:</label></td>
				<td><form:input type="text" path="role" id="role" /></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><form:input type="text" path="password" id="password" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>