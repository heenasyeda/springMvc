
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
<h1>Service Manager List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>ServiceManagerID</th><th>Name</th><th>Email</th><th>Contact</th><th>BranchID</th><th>Edit</th><th>Delete</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.serviceManagerID}</td>
<td>${list.name}</td>
<td>${list.email}</td>
<td>${list.contact}</td>
<td>${list.branchID}</td>


<td><a href="editService/${list.serviceManagerID}">Edit</a></td>
<td><a href="deleteService/${list.serviceManagerID}">Delete</a></td>
</tr>
</c:forEach>

</table>

<br/>
<a href="addService">Add New Service Managers</a>
</body>
</html>