<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">Add New User</a>
	<table border="1">
		<thead>
			<tr>
				<td>Sr.No</td>
				<td>Name</td>
				<td>Email</td>
				<td>Phno</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td>${user.userph}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>