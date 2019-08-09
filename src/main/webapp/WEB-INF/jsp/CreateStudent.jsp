<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Billing System</title>
</head>
<body>
	<h2>Enter Student Data</h2>
	${message }
	<form action="createStudent" method="POST">
		<table>
			<tr>
				<td><label>Register Number:</label></td>
				<td><input type="number" name="registerNumber" required /></td>
			</tr>
			<tr>
				<td><label>Name:</label></td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td><label>Department ID:</label></td>
				<td><input type="number" name="departmentId" required /></td>
			</tr>
			<tr>
				<td><label>Branch ID:</label></td>
				<td><input type="number" name="branchId" /></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td><label>Student Phone:</label></td>
				<td><input type="number" name="phone" required /></td>
			</tr>
			<tr>
				<td><label>Parent Phone:</label></td>
				<td><input type="number" name="parentPhone" required /></td>
			</tr>
			<tr>
				<td><label>Accountant ID:</label></td>
				<td><input type="number" name="modifiedByAccountant" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>