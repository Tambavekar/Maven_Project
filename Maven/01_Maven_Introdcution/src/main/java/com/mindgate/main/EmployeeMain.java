package com.mindgate.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter EmployeeId");
		int EmployeeId = scanner.nextInt();

		scanner.nextLine();
		System.out.println("enter name");
		String name = scanner.nextLine();
		System.out.println("enter salary");
		Double salary = scanner.nextDouble();

		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();

		Employee employee = new Employee(EmployeeId, name, salary);

		boolean result = employeeServiceInterface.addNewEmployee(employee);

		if (result) {
			System.out.println("insert successfull");
		} else {
			System.out.println("insert failed");
		}

	}

}
