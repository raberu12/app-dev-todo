package com.usc.matt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usc.matt.model.EmployeeModel;
import com.usc.matt.utils.JDBCUtils;

public class EmployeeDao {
	public int registerEmployee(EmployeeModel eModel) throws ClassNotFoundException {
		String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (first_name, last_name, username, password, position, department) VALUES (?, ?, ?, ?, ?, ?)";
		int result = 0;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
			preparedStatement.setString(1, eModel.getFirstName());
			preparedStatement.setString(2, eModel.getLastName());
			preparedStatement.setString(3, eModel.getUsername());
			preparedStatement.setString(4, eModel.getPassword());
			preparedStatement.setString(5, eModel.getPosition());
			preparedStatement.setString(6, eModel.getDepartment());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return result;
	}

	public EmployeeModel getEmployee(String username) throws ClassNotFoundException {
		String SELECT_EMPLOYEE_SQL = "SELECT first_name, last_name, department FROM employees WHERE username = ?";
		EmployeeModel employee = null;

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_SQL)) {

			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				employee = new EmployeeModel();
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setDepartment(rs.getString("department"));
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return employee;
	}

}
