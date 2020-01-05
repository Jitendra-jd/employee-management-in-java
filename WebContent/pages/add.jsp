<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<form action="<%=request.getContextPath()%>/saveEmpUrl" method="post">
	<table width="100%">

		<tr>
		
			<th  align="center"><span class="labelStyle"> Add employee:</span></th>
		</tr>
		<tr>
			<th width="20%">First Name</th>
			<th align="left"><input type="text" name="firstName"></th>
		</tr>

		<tr>
			<th>Last Name</th>
			<th align="left"><input type="text" name="lastName"></th>
		</tr>
		<tr>
			<th>Salary</th>
			<th align="left"><input type="text" name="salary"></th>
		</tr>
		<tr>
			<th>Age</th>
			<th align="left"><input type="text" name="age"></th>
		</tr>
		<tr>
			<th>Email</th>
			<th align="left"><input type="text" name="email"></th>
		</tr>

		<tr>
			<th>&nbsp;</th>
			<th align="left"><input type="submit" name="submit" value="save Employee"></th>
		</tr>
	</table>

</form>
</head>
<body>

</body>
</html>