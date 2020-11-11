package com.balaji.todoapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.quries.TodoQueries;

@Repository
public class TodoDAOImpl implements TodoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Learn Web Application Development", "Study"));
		todos.add(new Todo("Learn Spring MVC", "Study"));
		todos.add(new Todo("Learn Spring Rest Services", "Study"));
	}

	public List<Todo> retrieveTodos() {
		return jdbcTemplate.query(TodoQueries.SELECT_ALL_QUERY, new BeanPropertyRowMapper(Todo.class));
	}

	public void addTodo(Todo todo) {
		jdbcTemplate.update(TodoQueries.INSERT_QUERY, new Object[] { todo.getName(), todo.getCategory() });
	}

	public void deleteTodo(Integer todoId) {
		jdbcTemplate.update(TodoQueries.DELETE_QUERY, todoId);

	}

}
