<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Service Manager Details</title>
    <style>
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #ccc;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f5f5f5;
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
</head>
<body>
    <div class="container">
        <table>
            <tr>
                <th>Service Manager ID</th>
                <td>${serviceManagers.serviceManagerID}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${serviceManagers.name}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${serviceManagers.email}</td>
            </tr>
            <tr>
                <th>Contact</th>
                <td>${serviceManagers.contact}</td>
            </tr>
            <tr>
                <th>Branch ID</th>
                <td>${serviceManagers.branchID}</td>
            </tr>
            <tr>
                <th>Role</th>
                <td>${serviceManagers.role}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>${serviceManagers.password}</td>
            </tr>
        </table>
         <a href="javascript:history.back()" class="back-button">Back</a>
    </div>
</body>
</html>
