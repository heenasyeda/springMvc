<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Branches List</title>
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
	</style>
</head>
<body>
	<h1>Branches List</h1>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="branch" items="${branches}">
			<tr>
				<td>${branch.branchID}</td>
				<td>${branch.name}</td>
				<td>${branch.address}</td>
				<td>${branch.contact}</td>
				<td><a href="editbranch/${branch.branchID}">Edit</a></td>
				<td><a href="deletebranch/${branch.branchID}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div style="text-align: center;">
		<a href="addbranch" class="add-btn">Add New Branch</a>
	</div>
</body>
</html>
