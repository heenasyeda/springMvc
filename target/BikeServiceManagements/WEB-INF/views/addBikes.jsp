<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1>Add New Bikes</h1>

<form:form method="post" action="save">

<table >

<tr>

<td>BikeID:</td>

<td><form:input path="bikeID" /></td>

</tr>

<tr>

<td>OwnerName :</td>

<td><form:input path="ownerName" /></td>

</tr>

<tr>

<td>OwnerContact :</td>

<td><form:input path="ownerContact" /></td>

</tr>

<tr>

<td>Model :</td>

<td><form:input path="model" /></td>

</tr>

<tr>

<td>ServiceDetails :</td>

<td><form:input path="serviceDetails" /></td>

</tr>

<tr>

<td>ServiceManagerID :</td>

<td><form:input path="serviceManagerID" /></td>

</tr>

<tr>

<td>Status :</td>

<td><form:input path="status" /></td>

</tr>

<tr>

<td> </td>

<td><input type="submit" value="Save" /></td>

</tr>

</table>

</form:form>
</body>
</html>