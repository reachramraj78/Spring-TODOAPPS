package com.balaji.todoapp.dao;

import java.util.List;

import com.balaji.todoapp.bean.Todo;

public interface TodoDAO {
	public List<Todo> retrieveTodos();

	public void addTodo(Todo todo);

	public void deleteTodo(Integer todoId);
}
