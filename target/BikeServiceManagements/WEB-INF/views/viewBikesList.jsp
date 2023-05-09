<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>	
<body>
<h1>Bike List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>BikeID</th><th>OwnerName</th><th>OwnerContact</th><th>Model</th><th>ServiceDetails</th><th>ServiceManagerID</th><th>Status</th><th>Edit</th><th>Delete</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.bikeID}</td>
<td>${list.ownerName}</td>
<td>${list.ownerContact}</td>
<td>${list.model}</td>
<td>${list.serviceDetails}</td>
<td>${list.serviceManagerID}</td>
<td>${list.status}</td>

<td><a href="editBike/${list.bikeID}">Edit</a></td>
<td><a href="deletebike/${list.bikeID}">Delete</a></td>
</tr>
</c:forEach>

</table>

<br/>
<a href="addBikes">Add New bike</a>
</body>
</html>