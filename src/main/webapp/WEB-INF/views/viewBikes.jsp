<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" %>


<html>
<head>
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
</body>
</html>
