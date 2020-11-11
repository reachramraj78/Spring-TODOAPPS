package com.balaji.todoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo() {
		return "add-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoSubmit(HttpServletRequest request) {
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		todoService.addTodo(new Todo(newTodo, category));
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo")
	public String deleteTodo(HttpServletRequest request) {
		String todoId = request.getParameter("todoId");
		todoService.deleteTodo(new Integer(todoId));
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/list-todos")
	public String getAllTodos(Model model) {
		model.addAttribute("todos", todoService.retrieveTodos());
		return "list-todos";
	}

}
