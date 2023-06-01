<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" %>


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
		 .back-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #ddd;
            color: #333;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .back-button:hover {
            background-color: #ccc;
        }
	</style>
    <title>Bikes Assigned to Service Manager</title>
</head>
<body>
    <h1>Bikes Assigned to Service Manager: ${serviceManager.name}</h1>
    <table>
        <thead>
            <tr>
                <th>Bike ID</th>
                <th>Owner Name</th>
                <th>Owner Contact</th>
                <th>Model</th>
                <th>Service Details</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bikes}" var="bike">
                <tr>
                    <td>${bike.bikeID}</td>
                    <td>${bike.ownerName}</td>
                    <td>${bike.ownerContact}</td>
                    <td>${bike.model}</td>
                    <td>${bike.serviceDetails}</td>
                    <td>${bike.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
         <a href="javascript:history.back()" class="back-button">Back</a>
</body>
</html>
