package com.balaji.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.dao.TodoDAO;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoDAO todoDAO;

	public List<Todo> retrieveTodos() {
		return todoDAO.retrieveTodos();
	}

	public void addTodo(Todo todo) {
		todoDAO.addTodo(todo);
	}

	public void deleteTodo(Todo todo) {
		todoDAO.deleteTodo(todo);
	}

}
