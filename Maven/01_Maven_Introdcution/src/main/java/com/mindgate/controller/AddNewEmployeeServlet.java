package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

@WebServlet("/AddNewEmployeeServlet")
public class AddNewEmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int employeeid;
		String name;
		double salary;

		employeeid = Integer.valueOf(request.getParameter("employeeid"));
		name = request.getParameter("name");
		salary = Double.valueOf(request.getParameter("salary"));
		
		Employee employee=new Employee(employeeid, name, salary);
		EmployeeServiceInterface employeeServiceInterface=new EmployeeService();
		
		boolean result= employeeServiceInterface.addNewEmployee(employee);
		if(result)
		{
			response.sendRedirect("index.jsp");
		}
		else 
		{
			PrintWriter out =response.getWriter();
			out.println("Failed to add employee");
			
		}

		
	

	}

}
