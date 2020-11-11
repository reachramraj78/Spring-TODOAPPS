package com.balaji.todoapp.service;

import com.balaji.todoapp.dao.LoginDAO;
import com.balaji.todoapp.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO = new LoginDAOImpl();

	@Override
	public boolean isUserValid(String user, String password) {
		return loginDAO.isUserValid(user, password);
	}

}
