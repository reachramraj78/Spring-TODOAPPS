package com.balaji.todoapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.service.TodoService;
import com.balaji.todoapp.service.TodoServiceImpl;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {

	private TodoService todoService = new TodoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		todoService.deleteTodo(new Integer(request.getParameter("todoId")));
		response.sendRedirect("./list-todos.do");
	}
}