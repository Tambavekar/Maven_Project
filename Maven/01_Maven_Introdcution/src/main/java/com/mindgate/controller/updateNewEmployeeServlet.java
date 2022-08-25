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

/**
 * Servlet implementation class updateNewEmployeeServlet
 */
@WebServlet("/updateNewEmployeeServlet")
public class updateNewEmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int employeeId;
		String name;
		double salary;

		employeeId = Integer.valueOf(request.getParameter("employeeid"));
		name = request.getParameter("name");
		salary = Double.valueOf(request.getParameter("salary"));

		System.out.println("In updatedEmlpoyee");
		Employee employee = new Employee(employeeId, name, salary);

		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
		boolean result = employeeServiceInterface.updateEmployeedetail(employee);

		if (result) {
			response.sendRedirect("index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.print("Failed to updated");

		}

	}

}
