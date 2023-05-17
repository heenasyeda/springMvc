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
	body {
		font-family: Arial, sans-serif;
	}

	h1 {
		margin-top: 20px;
		margin-bottom: 30px;
		text-align: center;
	}

	table {
		width: 70%;
		border-collapse: collapse;
		margin: 0 auto;
	}

	th, td {
		padding: 10px;
		text-align: left;
	}

	th {
		background-color: #f2f2f2;
	}

	tr:nth-child(even) {
		background-color: #f9f9f9;
	}

	a {
		text-decoration: none;
		color: #333;
	}

	a:hover {
		color: #555;
	}

	.add-btn {
		display: inline-block;
		padding: 8px 12px;
		background-color: #4CAF50;
		color: #fff;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		text-decoration: none;
	}

	.add-btn:hover {
		background-color: #45a049;
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
