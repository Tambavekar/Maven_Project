package com.mindgate.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindgate.pojo.Employee;

public class EmployeeRepository implements EmployeeRepositoryInterface {

	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "mindgate";
	private String password = "mindgate";
	private ResultSet resultSet;

	private List<Employee> employeesList;
	private Connection connection;
	private PreparedStatement preparedStatement;

	private static final String INSERT_EMPLOYEE = "insert into employee_details values(?,?,?)";
	private static final String SELECT_ALL_EMPLOYEE = "select * from employee_details";
	private static final String DELETE_EMPLOYEE = "delete from employee_details where employee_id=?";
	private static final String UPDATE_EMPLOYEE = "update employee_details set name=?,salary=? where employee_id=?";
	private static final String SELECT_ONE_EMPLOYEE = "select * from employee_details WHERE employee_id=?";

	public boolean addNewEmployee(Employee employee) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);

			preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());

			int insertCount = preparedStatement.executeUpdate();

			if (insertCount > 0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Employee> getAlEmployees() {
		// TODO Auto-generated method stub

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);

			preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
			resultSet = preparedStatement.executeQuery();

			employeesList = new ArrayList<>();
			while (resultSet.next()) {
				int employeeId = resultSet.getInt("employee_Id");
				String name = resultSet.getString("name");
				Double salary = resultSet.getDouble("Salary");

				Employee employee = new Employee(employeeId, name, salary);
				employeesList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employeesList;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);

			preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
			preparedStatement.setInt(1, employeeId);

			int insertCount = preparedStatement.executeUpdate();

			if (insertCount > 0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}



	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(SELECT_ONE_EMPLOYEE);
			preparedStatement.setInt(1, employeeId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int empId = resultSet.getInt("employee_Id");
				String name = resultSet.getString("name");
				Double salary = resultSet.getDouble("Salary");

				Employee employee = new Employee(empId, name, salary);
				
				return employee;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateEmployeedetail(Employee employee) {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);

			preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
			preparedStatement.setInt(3, employee.getEmployeeId());
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getSalary());

			int insertCount = preparedStatement.executeUpdate();

			if (insertCount > 0) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		return false;
	}



}
