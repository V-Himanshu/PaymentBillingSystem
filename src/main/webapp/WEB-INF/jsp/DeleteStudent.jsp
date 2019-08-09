<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Billing System</title>
<script>
	
</script>
</head>
<body>
	Delete Student Data
	<form action="deleteStudent" method="POST">
		<table>
			<tr>
				<td><label>Register Number:</label></td>
				<td><input type="number" name="registerNumber" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form>

<!-- 
	<form action="deleteStudent" method="POST">
		<table>
		<tr>
				<td>Register Number:</td>
				<td>${registerNumber}</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Department Id:</td>
				<td>${departmentId}</td>
			</tr>
			<tr>
				<td>Branch Id:</td>
				<td>${branchId}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${email}</td>
			</tr>
			<tr>
				<td>Student Phone:</td>
				<td>${studentPhone}</td>
			</tr>
			<tr>
				<td>Parent Phone:</td>
				<td>${parentPhone}</td>
			</tr>
			<tr>
				<td>Modified By Accountant Id:</td>
				<td>${modifiedbyAccountant}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form>
	
	 -->
</body>
</html>