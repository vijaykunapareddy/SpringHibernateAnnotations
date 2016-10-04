<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
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
		<div style="color: teal; font-size: 30px">User Ordered Products List</div>
		<c:if test="${!empty orderedList}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					<td>Product ID</td>
					<td>Customer Name</td>
					<td>Customer Email</td>
					<td>Product Name</td>
					<td>Cost</td>
				</tr>
				<c:forEach items="${orderedList}" var="accepted">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						<td><c:out value="${accepted.p_id}" />
						</td>
						<td><c:out value="${accepted.firstnameList}" />
						</td>
						<td><c:out value="${accepted.emailList}" />
						</td>
						<td><c:out value="${accepted.pNameList}" />
						</td>
						<td><c:out value="${accepted.costList}" />$
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>
