<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Data</h2>
	<form action="searchAccountantForUpdate" method="POST">
		<table>
			<tr>
				<td><label>Accountant Id:</label></td>
				<td><input type="number" name="accountantId" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Search" /></td>
			</tr>

		</table>
	</form>
	<form action="updateAccountant" method="POST">
			<table>
			<tr>
				<td><label>Accountant Id:</label></td>
				<td><input type="number" value="${accountantId}" name="accountantId" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" value="${name}" name="name" /></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input type="text" value="${salary}" name="salary" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" value="${phone}" name="phone" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" value="${email}" name="email" /></td>
			</tr>
			<tr>
				<td>Branch Id:</td>
				<td><input type="text" value="${branchId}"  name="branchId"/></td>
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