package com.balaji.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.balaji.todoapp.quries.TodoQueries;
import com.balaji.todoapp.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isUserValid(String user, String password) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(TodoQueries.LOGIN_QUERY);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1) == 0 ? false : true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(resultSet, preparedStatement, connection);
		}
		return false;
	}

}
