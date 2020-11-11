package com.balaji.todoapp.service;

import java.util.List;

import com.balaji.todoapp.bean.Todo;

public interface TodoService {
	public List<Todo> retrieveTodos();

	public void addTodo(Todo todo);

	public void deleteTodo(Integer todoId);
}
