<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Service Manager List</title>
	<style>
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
	</style>
</head>
<body>
	<h1 style="text-align: center;">Service Manager List</h1>
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
					
					 <td><a href="viewBikes/${serviceManager.serviceManagerID}">Bike Details</a></td> 
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
