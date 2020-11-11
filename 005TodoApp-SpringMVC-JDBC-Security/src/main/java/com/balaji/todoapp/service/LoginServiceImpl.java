package com.balaji.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.todoapp.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public boolean isUserValid(String user, String password) {
		return loginDAO.isUserValid(user, password);
	}

}
