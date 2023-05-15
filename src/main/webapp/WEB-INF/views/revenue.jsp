<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Revenue</title>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td {
        padding: 5px;
        text-align: left;
    }
</style>
</head>
<body>
    <h1>Revenue Report</h1>
    <h3>Revenue By Branch</h3>
    <table>
        <thead>
            <tr>
                <th>Branch Name</th>
                <th>Total Revenue</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${revenueByBranch}">
                <tr>
                    <td>${row[0]}</td>
                    <td>${row[1]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
   <hr> 
    
    <h3>Total Revenue</h3>
    <p>${totalRevenue}</p>
    
    <hr>
    
    <h3>Revenue By Service Manager</h3>
    <table>
        <thead>
            <tr>
                <th>Service Manager</th>
                <th>Total Revenue</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${revenueByServiceManager}">
                <tr>
                    <td>${row[0]}</td>
                    <td>${row[1]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="viewService">back</a>
</body>
</html>
