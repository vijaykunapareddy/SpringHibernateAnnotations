<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>
<body>
	<center>
		<div style="color:Grey; width:100%; height:50px;">
		</div>
		<hr>
		<div style="color: teal; font-size: 30px">Welcome to the Application</div>

		<form:form id="loginForm" modelAttribute="user" method="post" action="login">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login" />
					</td>
					
					
				</tr>
			</table>
			
		</form:form>
		<form:form id="createAccountForm" modelAttribute="user" method="post" action="form">
			<input type="submit" value="Create Account" />
		</form:form>
		<input id="ajaxCall" type="submit" value="Ajax Call" />
	</center>
</body>
<script>
	$(document).ready(function() {
		alert(location.hostname);
		$.ajax({
			type: "POST",
			url : '/SpringHibernateAnnotations/userAccount',
            dataType: "JSON",
            complete: function(data) {
                if(data != '') {
                	
                	console.log(data);
                	console.log('vijay');
                }   
             }
		});
	});
</script>
</html>
