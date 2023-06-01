<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service Manager List</title>
<style>
 .search-form {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 20px;
    }
    
    .search-form label {
        font-weight: bold;
        margin-bottom: 10px;
    }
    
    .search-form select,
    .search-form input[type="text"] {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        width: 300px;
        margin-bottom: 10px;
    }
    
    .search-form button {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    
    .search-form button:hover {
        background-color: #45a049;
    }
table {
	border-collapse: collapse;
	width: 70%;
	margin: 0 auto;
}

th, td {
	padding: 10px;
	text-align: center;
	border: 1px solid black;
}

th {
	background-color: #008CBA;
	color: #FFF;
}

td a {
	color: #008CBA;
	text-decoration: none;
}

td a:hover {
	color: #005b81;
	font-weight: bold;
}

.add-link {
	display: block;
	text-align: center;
	margin-top: 20px;
	font-size: 20px;
	font-weight: bold;
}

.revenue-link {
	display: block;
	text-align: center;
	margin-top: 10px;
	font-size: 16px;
}

.login-link {
	display: block;
	text-align: center;
	margin-top: 10px;
	font-size: 16px;
}

/* Styling for the links */
.add-link,
.revenue-link,
.login-link {
  display: inline-block;
  margin-right: 10px;
  padding: 8px 12px;
  text-decoration: none;
  color: #ffffff;
  background-color: #007bff;
  border-radius: 4px;
}

/* Hover effect */
.add-link:hover,
.revenue-link:hover,
.login-link:hover {
  background-color: #0056b3;
}

/* Styling for the "view Branch" link */
.revenue-link.list-link {
  background-color: #28a745;
}

/* Hover effect for the "view Branch" link */
.revenue-link.list-link:hover {
  background-color: #1e7e34;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">Service Manager List</h1>
	<form action="/BikeServiceManagements/search" method="GET">
  <label for="searchOption"></label>
  <select name="searchOption" id="searchOption">
    <option value="ServiceManagerId" selected>Manager Id</option>
    <option value="Name">Manager Name</option>
  </select>
  <label for="searchCriteria"></label>
  <input type="text" name="searchCriteria" id="searchCriteria" placeholder="type here">
  <button type="submit">Search</button>
  
</form>
<a href="ascending">Asc</a>	
<a href="decending">dsc</a>

    </br>
	<table>
		<thead>
			<tr>
				<th>Service Manager ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>Branch ID</th>

				<th>Role</th>
				<th>Password</th>
				<th>Bike Details</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="serviceManager" items="${list}">
				<tr>
					<td>${serviceManager.serviceManagerID}</td>
					<td>${serviceManager.name}</td>
					<td>${serviceManager.email}</td>
					<td>${serviceManager.contact}</td>
					<td>${serviceManager.branchID}</td>
					<td>${serviceManager.role}</td>
					<td>${serviceManager.password}</td>

					<td><a href="viewBikes/${serviceManager.serviceManagerID}">Bike
							Details</a></td>
					<td><a href="editService/${serviceManager.serviceManagerID}">Edit</a></td>
					<td><a href="deleteService/${serviceManager.serviceManagerID}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<a href="addService" class="add-link">Add New Service Manager</a>
	<a href="revenue" class="revenue-link">Check Revenue</a>
	<a href="list" class="revenue-link">view Branch</a>
	<a href="login" class="login-link"> Logout</a>
	
	
	
</body>
</html>
