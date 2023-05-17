<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" %>



<html>
<head>
	<title>Bikes Assigned to Service Manager</title>
	<style>
		table {
			border-collapse: collapse;
			width: 100%;
		}

		th, td {
			text-align: left;
			padding: 8px;
			border-bottom: 1px solid #ddd;
		}

		tr:nth-child(even) {
			background-color: #f2f2f2;
		}

		th {
			background-color:#3ee9ef;
			color: white;
		}

		h1 {
			text-align: center;
		}
	</style>
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
                <th>Edit</th>
                <th>Delete</th>
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
                    
                 <td><a href="editManager/${bike.bikeID}">Edit</a></td>
                  <td><a href="deletebike/${bike.bikeID}">Delete</a></td>
                </tr>
            </c:forEach>
            
            	
        </tbody>
    </table>
    <a href="addManager">Add New bike</a>
</body>
</html>
