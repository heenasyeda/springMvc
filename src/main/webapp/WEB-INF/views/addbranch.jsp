<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
<h1>Add New Product</h1>
<form:form method="POST" action="/BikeServiceManagements/savebranch">
	<table>
<%-- 
		<tr>

			<td>Branch ID:</td>

			<td><form:hidden type="text" path="branchID" /></td>

		</tr>
 --%>
		<tr>

			<td>Branch Name:</td>

			<td><form:input type="text" path="name" /></td>

		</tr>


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








 


