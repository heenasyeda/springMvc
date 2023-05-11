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
	<h1>Edit Branch</h1>

	<form:form method="POST" action="/BikeServiceManagements/editsavebranch" >
	<table>
		
		
		 <tr>
			<td>Branch ID:</td>
			<td><form:input type="text" path="BranchID" /></td>
		</tr>  
		<tr>
			<td>Branch Name:</td>
			<td><form:input type="text" path="name" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><form:input type="text" path="address" /></td>
		</tr>
		<tr>
			<td>Contact:</td>
			<td><form:input type="text" path="contact" /></td>
		</tr>
		
		
		
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>