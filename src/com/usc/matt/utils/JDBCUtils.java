package com.usc.matt.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
	private static String jdbcUser = "root";
	private static String jdbcPassword = "root";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void printSQLException(SQLException e) {

	}
}