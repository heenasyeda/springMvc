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
</head>
<body>
	<h1>Branches List</h1>

	 

	<table border="2" width="70%" cellpadding="2">


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
	<BR />
<a href="addbranch">Add New branch</a>
</body>
</html>
