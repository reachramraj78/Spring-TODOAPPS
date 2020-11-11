package com.balaji.todoapp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isUserValid(String user, String password) {
		if (user.equals("balaji") && password.equals("balaji"))
			return true;

		return false;
	}

}
