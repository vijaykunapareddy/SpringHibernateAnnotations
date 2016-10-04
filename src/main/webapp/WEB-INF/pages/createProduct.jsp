<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create product</title>
</head>
<body>
	<div style="color:Grey; width:100%; height:50px;">Welcome to the user ${sessionScope.email}
	<a href="logout" style="float:right">Logout</a>
	</div>
	<hr>
	<a href="entrepreneurAccount">User Ordered Products By User</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="createProduct">Create Product</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="myProducts">My Products List</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<center>

		<div style="color: teal; font-size: 30px">Create Product</div>
		
		<form:form id="registerForm" commandName="addProduct" method="post" action="createProductItem">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="pname">Product Name</form:label></td>
					<td><form:input path="pname" /></td>
				</tr>
				<tr>
					<td><form:label path="cost">Cost</form:label></td>
					<td><form:input path="cost" /></td>
				</tr>
				<tr>
					<td><form:label path="discount">Discount</form:label></td>
					<td><form:input path="discount" /></td>
				</tr>
				<tr>
					<td><form:label path="company">Company</form:label></td>
					<td><form:input path="company" /></td>
				</tr>
				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create" />
					</td>
				</tr>
			</table>
		</form:form>

		
	</center>
</body>
</html>
