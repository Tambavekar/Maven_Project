package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.Employee;
import com.mindgate.repository.EmployeeRepository;
import com.mindgate.repository.EmployeeRepositoryInterface;

public class EmployeeService implements EmployeeServiceInterface {

	private EmployeeRepositoryInterface employeeRepositoryInterface = new EmployeeRepository();

	@Override
	public boolean addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		return employeeRepositoryInterface.addNewEmployee(employee);

	}

	@Override
	public List<Employee> getAlEmployees() {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.getAlEmployees();
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean updateEmployeedetail(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.updateEmployeedetail(employee);
	}



}
