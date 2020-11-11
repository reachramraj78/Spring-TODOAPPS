package com.balaji.todoapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.balaji.todoapp.service.LoginService;
import com.balaji.todoapp.service.LoginServiceImpl;
import com.balaji.todoapp.service.TodoService;
import com.balaji.todoapp.service.TodoServiceImpl;

/*

 // Method descriptor #15 ()V
 public void init() throws javax.servlet.ServletException;

 // Method descriptor #37 (Ljavax/servlet/ServletRequest;Ljavax/servlet/ServletResponse;)V
 public void service(javax.servlet.ServletRequest arg0, javax.servlet.ServletResponse arg1) throws javax.servlet.ServletException, java.io.IOException;

 // Method descriptor #15 ()V
 public void destroy();

 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private LoginService userValidationService = new LoginServiceImpl();
	private TodoService todoService = new TodoServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isUserValid = userValidationService.isUserValid(name, password);
		if (isUserValid) {
			request.getSession().setAttribute("name", name);
			System.out.println("Is User Valid: "+isUserValid);
			response.sendRedirect("./list-todos.do");
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}
	}

}