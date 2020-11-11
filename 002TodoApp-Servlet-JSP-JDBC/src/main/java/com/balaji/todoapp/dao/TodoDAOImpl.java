package com.balaji.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.quries.TodoQueries;
import com.balaji.todoapp.util.ConnectionUtil;

public class TodoDAOImpl implements TodoDAO {

	@Override
	public List<Todo> retrieveTodos() {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Todo> todos = null;
		try {
			preparedStatement = connection.prepareStatement(TodoQueries.SELECT_ALL_QUERY);
			resultSet = preparedStatement.executeQuery();
			todos = new ArrayList<>();
			while (resultSet.next()) {
				Todo todo = new Todo();
				todo.setId(resultSet.getInt("id"));
				todo.setName(resultSet.getString("name"));
				todo.setCategory(resultSet.getString("category"));
				todos.add(todo);
			}
			return todos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(resultSet, preparedStatement, connection);
		}
		return null;
	}

	@Override
	public void addTodo(Todo todo) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(TodoQueries.INSERT_QUERY);
			preparedStatement.setString(1, todo.getName());
			preparedStatement.setString(2, todo.getCategory());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
	}

	@Override
	public void deleteTodo(Integer todoId) {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(TodoQueries.DELETE_QUERY);
			preparedStatement.setInt(1, todoId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
	}

}
