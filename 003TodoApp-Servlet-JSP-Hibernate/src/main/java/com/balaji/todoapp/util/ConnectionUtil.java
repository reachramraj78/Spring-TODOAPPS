package com.balaji.todoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionUtil {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tododb", "root", "root");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement preparedStatement, Connection connection) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			close(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			close(preparedStatement, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
