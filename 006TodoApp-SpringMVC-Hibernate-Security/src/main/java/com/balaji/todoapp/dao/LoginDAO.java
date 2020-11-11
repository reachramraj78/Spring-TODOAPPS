package com.balaji.todoapp.dao;

import com.balaji.todoapp.bean.User;

public interface LoginDAO {
	User findByUserName(String username);
}
