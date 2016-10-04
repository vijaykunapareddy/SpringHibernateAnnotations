<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<div style="color:Grey; width:100%; height:50px;">Welcome to the user ${sessionScope.email}
	<a href="logout" style="float:right">Logout</a>
	</div>
	<hr>
	<center>

		<div style="color: teal; font-size: 30px">Registration Form</div>

		<c:url var="userRegistration" value="saveUser.html" />
		<form:form id="registerForm" modelAttribute="user" method="post" action="register">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="phone">Phone</form:label></td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td><form:label path="address">Address</form:label></td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td><form:label path="designation">Designation</form:label></td>
					<td><form:input path="designation" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" />
					</td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>
