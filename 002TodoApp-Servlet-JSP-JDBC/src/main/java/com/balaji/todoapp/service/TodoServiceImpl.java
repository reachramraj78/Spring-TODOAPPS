package com.balaji.todoapp.service;

import java.util.ArrayList;
import java.util.List;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.dao.TodoDAO;
import com.balaji.todoapp.dao.TodoDAOImpl;

public class TodoServiceImpl implements TodoService{
	
	private TodoDAO todoDAO = new TodoDAOImpl();

	public List<Todo> retrieveTodos() {
		return todoDAO.retrieveTodos();
	}

	public void addTodo(Todo todo) {
		todoDAO.addTodo(todo);
	}

	public void deleteTodo(Integer todoId) {
		todoDAO.deleteTodo(todoId);
	}

}
