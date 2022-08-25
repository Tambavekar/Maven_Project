package com.mindgate.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeCRUDMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choice any one");

		List<Employee> allEmployees = new ArrayList<>();
		EmployeeServiceInterface employeeServiceInterface = new EmployeeService();

		int choice;
		String continueChoice;
		do {
			System.out.println("1.   add New Employee");
			System.out.println("2.   Select All Employee");
			System.out.println("3.   Delete Employee");
			System.out.println("4.   Select One Employee");
			System.out.println("5.   Update Employee");

			choice = scanner.nextInt();

			switch (choice) {
			// switch cases without break statements
			case 1:
				System.out.println("Enter EmployeeId");

				scanner.nextLine();
				int EmployeeId = scanner.nextInt();

				System.out.println("enter name");
				String name = scanner.nextLine();
				System.out.println("enter salary");
				Double salary = scanner.nextDouble();

				Employee employee = new Employee(EmployeeId, name, salary);

				boolean result = employeeServiceInterface.addNewEmployee(employee);

				if (result) {
					System.out.println("insert successfull");
				} else {
					System.out.println("insert failed");
				}

				break;
			case 2:

				allEmployees = employeeServiceInterface.getAlEmployees();
				for (Employee e : allEmployees) {
					System.out.println(e);
				}

				break;

			case 3:
				System.out.println("Enter EmployeeId");
				EmployeeId = scanner.nextInt();

				result = employeeServiceInterface.deleteEmployeeByEmployeeId(EmployeeId);
				if (result) {
					System.out.println("Delete successfull");
				} else {
					System.out.println("Delete failed");
				}
				break;

			case 4:
				break;

			case 5:
				break;

			default:
				System.out.println("Invaild Choice");
				break;
			}

			System.out.println("Do you Want To Continue");
			continueChoice = scanner.next();
		} while (continueChoice.equals("Yes"));

	}

}
