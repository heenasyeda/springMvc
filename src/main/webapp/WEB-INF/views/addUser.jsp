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

<form:form method="post" action="saveUser">

<table >
<!-- 
<tr>

<td>User Id:</td>

<td><form:input path="userId" /></td>

</tr>
 -->
<tr>

<td>User Name :</td>

<td><form:input path="username" /></td>

</tr>

<tr>

<td>Password :</td>

<td><form:input path="password" /></td>

</tr>

<tr>

<td>Email :</td>

<td><form:input path="email" /></td>

</tr>

<tr>

<td>Role :</td>

<td><form:input path="role" /></td>

</tr>




<td><input type="submit" value="Save" /></td>

</tr>

</table>

</form:form>

</body>
</html>