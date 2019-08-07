<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Enter Accountant Data</h2>
	${message }
	<form action="createAccountant" method="POST">
		<table>
			<tr>
				<td><label>Accountant Id:</label></td>
				<td><input type="number" name="accountantId" required /></td>
			</tr>
			<tr>
				<td><label>Name:</label></td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td><label>Salary:</label></td>
				<td><input type="number" name="salary" required /></td>
			</tr>
			<tr>
				<td><label>Phone:</label></td>
				<td><input type="number" name="phone" /></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td><label>Branch Id:</label></td>
				<td><input type="number" name="branchId" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>