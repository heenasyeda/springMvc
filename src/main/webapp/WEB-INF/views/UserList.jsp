<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>

<head>
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
<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

<h1>User List</h1>

 

<table border="2" width="70%" cellpadding="2">

<tr><th>userId</th><th>password</th><th>email</th><th>role</th><th>Edit</th><th>Delete</th></tr>

<c:forEach var="user" items="${list}">

 

<tr>

<td>${user.userId}</td>

<td>${user.password}</td>

<td>${user.email}</td>

<td>${user.role}</td>

<td><a href="editUser/${user.userId}">Edit</a></td>

<td><a href="deleteuser/${user.userId}">Delete</a></td>

</tr>

</c:forEach>

</table>

<br/>

<a href="addUser">Add New item</a>

</body>

</html>