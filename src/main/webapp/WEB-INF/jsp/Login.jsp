<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
p {
	color: red;
}
</style>
</head>
<body>
	<p>${message }</p>
	<form method="POST" action="loginProcess">
		<table>
			<tr>
				<td>User name:</td>
				<td><input type="number" name="userName" required="required" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required="required" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>