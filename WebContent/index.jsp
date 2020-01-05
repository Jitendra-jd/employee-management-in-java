<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First login page</title>
</head>
<body>
	<!--<form action="loginUrlPages"  method="post">-->
		<form action="loginUrlPages" method="post">
	
	
	<table width="50%">
		<tr>
			<td colspan="2"><h2>User login::</h2></td>
		</tr>
		<tr>
			<td>UserName:</td>
			<td><input type="text" name="userName" ></td>
		</tr>
		<tr>
			<td>password:</td>
			<td><input type="text" name="password" ></td>
		</tr>
		<tr>
			<td>..............</td>
			<td><input type="submit" name="submit" value="login"></td>
		</tr>

	</table>
	</form>
	<h3>${msg}</h3>
</body>
</html>