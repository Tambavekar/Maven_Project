<%@page import="com.mindgate.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update New Employee</title>
</head>
<body>
	<h3>Update New Employee</h3>
	<% Employee employee=(Employee) session.getAttribute("emp"); %>
	<form action="updateNewEmployeeServlet" method="post">
		EmployeeId <input type="text" name="employeeid" readonly="true" value="<%=employee.getEmployeeId()%>"> 
		<br> <br>	
		Name <input type="text" name="name" value="<%=employee.getName()%>"> 
		<br> <br>
		 Salary <input type="text" name="salary" value="<%=employee.getSalary()%>">  
		 <br> <br> <input type="submit"
			value="Update Employee">
	</form>
</body>
</html>