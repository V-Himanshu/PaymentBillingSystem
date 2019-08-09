<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Delete Student Data
	<form action="deleteAccountant" method="POST">
		<table>
			<tr>
				<td><label>Register Number:</label></td>
				<td><input type="number" name="accountantId" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form>
</body>
</html>