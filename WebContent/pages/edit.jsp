<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<form action="<%=request.getContextPath()%>/editEmpUrl" method="post">
	<table width="100%">

		<tr>
		<th><input type="hidden" name="eId" value="${empDetail.getId ()}"></th>

			<th align="center"><span class="labelStyle"> Add
					employee:</span></th>
		</tr>
		<tr>
			<th width="20%">First Name</th>
			<th align="left"><input type="text" name="firstName"
				value="${empDetail.getFirstName() }"></th>
		</tr>

		<tr>
			<th>Last Name</th>
			<th align="left"><input type="text" name="lastName"
				value="${empDetail.getLastName() }"></th>
		</tr>
		<tr>
			<th>Salary</th>
			<th align="left"><input type="text" name="salary"
				value="${empDetail.getSalary() }"></th>
		</tr>
		<tr>
			<th>Age</th>
			<th align="left"><input type="text" name="age"
				value="${empDetail.getAge() }"></th>
		</tr>
		<tr>
			<th>Email</th>
			<th align="left"><input type="text" name="email"
				value="${empDetail.getEmail() }"></th>
		</tr>

		<tr>
			<th>&nbsp;</th>
			<th align="left"><input type="submit" name="submit"
				value="save Employee"></th>
		</tr>
	</table>

</form>
</head>
<body>

</body>
</html>