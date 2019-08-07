<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Search Student</h2>

	<form action="searchStudent" method="POST">
		<table>
			<tr>
				<td><label>Register Number:</label></td>
				<td><input type="number" name="registerNumber" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

		</table>
		
		<table>
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
				<td>Active Status:</td>
				<td>${activeStatus}</td>
			</tr>
		</table>

	</form>
</body>
</html>