<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="java.util.ArrayList" %>
    <%@ page import ="java.util.List" %>
    <%@ page import ="com.neo.service.EmployeeService" %>
    <%@ page import="com.neo.service.EmployeeSeviceImpl" %>
    <%@ page import ="com.neo.model.Employee" %>
    <%
    EmployeeService es=new EmployeeSeviceImpl();
    List<Employee>employeeList =es.allEmployees();
    request.setAttribute("employeeList", employeeList);
    
    
    
    %>
    <%@
    include file="header.jsp"
    %>
    <%@  include file="include.jsp" %>
    
<table border="1" width="100%">
<thead>
<tr>
<th colspan="8"><Employee List::<c:out value="${msg }"/>
</th>
</tr>
<tr>
<th> S.No</th>
<th>First Name</th>
<th>Last Name</th>
<th>Salary</th>
<th>Age</th>
<th>Email</th>
<th colspan=2>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${employeeList }" var="emp" varStatus="status">

<tr>
<td>............${status.count}</td>
<td>${emp.firstName}</td>
<td><c:out value="${emp.lastName }"/></td>
<td><c:out value="${emp.salary }"/></td>
<td><c:out value="${emp.age }"/></td>
<td><c:out value="${emp.email }"/></td>
<td><a href="<%=request.getContextPath() %>/empurl?action=edit&eId=<c:out value="${ emp.id}"/>">Update</a></td>
<td><a href="<%=request.getContextPath() %>/empurl?action=delete&eId=<c:out value="${emp.id }"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
