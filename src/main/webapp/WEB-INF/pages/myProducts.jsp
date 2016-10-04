<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Page</title>
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
		<div style="color: teal; font-size: 30px">My Products Details</div>
		<c:if test="${!empty products}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					<td>Product ID</td>
					<td>Product Name</td>
					<td>Cost</td>
					<td>Discount</td>
					<td>Company</td>
					<td>Description</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${products}" var="products">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						
						<td><c:out value="${products.p_id}" />
						</td>
						<td><c:out value="${products.pname}" />
						</td>
						<td><c:out value="${products.cost}" />$
						</td>
						<td><c:out value="${products.discount}" />%
						</td>
						<td><c:out value="${products.company}" />
						</td>
						</td>
						<td><c:out value="${products.description}" />
						</td>
						<td><a href="deleteMyProduct?p_id=${products.p_id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>
