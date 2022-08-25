package com.mindgate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindgate.pojo.Employee;
import com.mindgate.repository.EmployeeRepositoryInterface;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int employeeId;
		PrintWriter out = response.getWriter();
		employeeId = Integer.valueOf(request.getParameter("action"));

		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();
		String choice = request.getParameter("operation");

		switch (choice) {
		case "Delete": {

			boolean result = employeeServiceInterface.deleteEmployeeByEmployeeId(employeeId);

			if (result) {
				response.sendRedirect("index.jsp");
			} else {
				out.println("Delete Failed");
			}

		}
			break;

		case "update": {
			
			Employee employee= employeeServiceInterface.getEmployeeByEmployeeId(employeeId);
			System.out.println(employee);
			
			HttpSession httpSession =request.getSession();
			httpSession.setAttribute("emp",employee);
			response.sendRedirect("updateemployee.jsp");
			break;

		}

		}
	}
}
