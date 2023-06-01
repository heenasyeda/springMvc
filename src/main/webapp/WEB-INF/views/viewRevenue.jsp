
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>	
<body>

<h1>Revenue</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>RevenueID</th><th>BranchID</th><th>RevenueAmount</th><th>TimePeriod</th><th>ServiceManagerID</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<td>${list.revenueID}</td>
<td>${list.branchID}</td>
<td>${list.revenueAmount}</td>
<td>${list.timePeriod}</td>
<td>${list.serviceManagerID}</td>




</tr>
</c:forEach>

</table>
<%-- <a href="addRevenue/${serviceManagerId}">Add revenue</a> --%>
<a href="<c:url value='/serviceManagers/addRevenue/'/><c:out value='${serviceManagerId}'/>">Add revenue</a>
<br/>

</body>
</html>