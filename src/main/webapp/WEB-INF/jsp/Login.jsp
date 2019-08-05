<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message }
<form:form method="POST" action="loginProcess"  modelAttribute="login">
	<table>
            <tr>
               <td><form:label path = "userName">User Name:</form:label></td>
               <td><form:input path = "userName" /></td>
            </tr>
            <tr>
               <td><form:label path = "password">Password</form:label></td>
               <td><form:input type="password" path = "password" /></td>
            </tr>
            <tr>
               <td></td>
               <td></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Login"/>
               </td>
            </tr>
         </table> 
         
</form:form>

${loginpart}

</body>
</html>