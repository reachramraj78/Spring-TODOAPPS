package com.balaji.todoapp.dao;

import com.balaji.todoapp.bean.User;

public interface LoginDAO {
	public boolean isUserValid(String username, String password);
	public void deleteByUsername(String username);
	public void addUser(User user);
}
