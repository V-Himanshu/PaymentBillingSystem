<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Billing System</title>
</head>
<body>
	<h2>Update Data</h2>
	<form action="searchStudentForUpdate" method="POST">
		<table>
			<tr>
				<td><label>Register Number:</label></td>
				<td><input type="number" name="registerNumber" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

		</table>
	</form>
	<form action="updateStudent" method="POST">
			<table>
			<tr>
				<td><label>Register Number:</label></td>
				<td><input type="number" value="${registerNumber}" name="registerNumber" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${name}" name="name" /></td>
			</tr>
			<tr>
				<td>Department Id:</td>
				<td><input type="text" value="${departmentId}" name="departmentId" /></td>
			</tr>
			<tr>
				<td>Branch Id:</td>
				<td><input type="text" value="${branchId}" name="branchId" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" value="${email}" name="email" /></td>
			</tr>
			<tr>
				<td>Student Phone:</td>
				<td><input type="text" value="${studentPhone}"  name="phone"/></td>
			</tr>
			<tr>
				<td>Parent Phone:</td>
				<td><input type="text" value="${parentPhone}" name="parentPhone" /></td>
			</tr>
			<tr>
				<td>Modified By Accountant Id:</td>
				<td><input type="text" value="${modifiedbyAccountant}" name="modifiedByAccountant" /></td>
			</tr>
			<tr>
				<td>Active Status:</td>
				<td><input type="text" value="${activeStatus}" name="activeStatus" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
</form>

</body>
</html>