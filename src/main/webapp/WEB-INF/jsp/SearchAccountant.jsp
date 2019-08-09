<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Search Data</h2>
	<form action="searchAccountant" method="POST">
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
	
			<table>
			<tr>
				<td><label>Accountant Id:</label></td>
				<td>${accountantId}</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td>${salary}</td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td>${phone}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${email}</td>
			</tr>
			<tr>
				<td>Branch Id:</td>
				<td>${branchId}</td>
			</tr>
			<tr>
				<td>Active Status:</td>
				<td>${activeStatus}</td>
			</tr>
			
		</table>

</body>
</html>