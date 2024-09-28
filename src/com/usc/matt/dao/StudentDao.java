package com.usc.matt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.usc.matt.model.StudentModel;
import com.usc.matt.utils.JDBCUtils;

public class StudentDao {
	public int registerStudent(StudentModel studentModel) throws ClassNotFoundException {
		String INSERT_STUDENT_SQL = "INSERT INTO students (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
		int result = 0;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, studentModel.getFirstName());
			preparedStatement.setString(2, studentModel.getLastName());
			preparedStatement.setString(3, studentModel.getUserName());
			preparedStatement.setString(4, studentModel.getPassword());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return result;
	}
}