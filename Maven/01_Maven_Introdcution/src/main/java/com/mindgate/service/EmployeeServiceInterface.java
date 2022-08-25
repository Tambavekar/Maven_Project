package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.Employee;

public interface EmployeeServiceInterface {
	boolean addNewEmployee(Employee employee);
	List<Employee> getAlEmployees();
	boolean deleteEmployeeByEmployeeId(int employeeId);
 boolean updateEmployeedetail(Employee employee);
	Employee getEmployeeByEmployeeId(int employeeId);

}
