<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Revenue Report</title>
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
            margin: 0 auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #acb4b4;
        }

        a {
            display: inline-block;
            margin-top: 10px;
        }

        a.back-button {
            background-color: #818a8a;
            color: #0b1b1c;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 4px;
        }

        a.back-button:hover {
            background-color: #818a8a;
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
    <a href="viewService" class="back-button">Back</a>
</body>
</html>
