
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
<h1>Revenue</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>RevenueID</th><th>BranchID</th><th>RevenueAmount</th><th>TimePeriod</th><th>ServiceManagerID</th><th>Edit</th><th>Delete</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.revenueID}</td>
<td>${list.branchID}</td>
<td>${list.revenueAmount}</td>
<td>${list.timePeriod}</td>
<td>${list.serviceManagerID}</td>

<td><a href="editRevenue/${list.revenueID}">Edit</a></td>
<td><a href="deleteRevenue/${list.revenueID}">Delete</a></td>


</tr>
</c:forEach>

</table>

<br/>

</body>
</html>