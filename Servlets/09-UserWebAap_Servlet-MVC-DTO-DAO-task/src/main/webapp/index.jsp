<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Save User</h2>

	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print(msg);
	}
	%>
	<form action="user" method="post">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>UserEmail:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>UserPhno:</td>
				<td><input type="number" name="phno" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>

		</table>

	</form>
	<a href="user">View Users</a>
</body>
</html>