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
	<a href="userAccount">UserAccount</a>
	<a href="userDeletedProducts">UserDeletedProducts</a>
	<a href="userOrderedProducts">UserOrderedProducts</a>
	<center>
	
		<div style="color: teal; font-size: 30px">User Bought List</div>
		
		<c:if test="${!empty acceptedList}">
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					<td>Product ID</td>
					<td>Product Name</td>
					<td>Cost</td>
					<td>Company</td>
				</tr>
				<c:forEach items="${acceptedList}" var="accepted">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						<td><c:out value="${accepted.p_id}" />
						</td>
						<td><c:out value="${accepted.pname}" />
						</td>
						<td><c:out value="${accepted.cost}" />$
						</td>
						<td><c:out value="${accepted.company}" />
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>
