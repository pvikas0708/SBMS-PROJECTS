<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Save Employee Details</h2>
	
	<% 
		String msg = (String)request.getAttribute("msg");

			if(msg != null){
				out.print(msg);
			}
	%>
	
	<form action="insert" method="POST">
		<table>
			<tr>
				<td>Emp Name:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			
			<tr>
				<td>Emp Email:</td>
				<td><input type="email" name="email"/>
			</tr>
			
			<tr>
				<td>Emp Gender:</td>
				<td>
					<input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="Female">Female
				</td>
			</tr>
			
			<tr>
				<td>Emp Dept:</td>
				<td>
					<select name="dept">
						<option value="">-Select-</option>
						<option value="Development">Development</option>
						<option value="Testing">Testing</option>
						<option value="Database">Database</option>
						<option value="Operations">Operations</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Emp Exp:</td>
				<td>
					<select name="exp">
						<option value="">-Select-</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
	
	<a href="emps.jsp">View Employees</a>
	
</body>
</html>

</html>