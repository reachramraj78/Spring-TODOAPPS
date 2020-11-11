package com.balaji.todoapp.quries;

public interface TodoQueries {

	String LOGIN_QUERY = "SELECT COUNT(*) FROM User u WHERE u.username = :username AND password = :password";
	String DELETE_TODO_QUERY = "DELETE FROM Todo t WHERE t.id = :id";
	String DELETE_LOGIN_QUERY = "DELETE FROM User u WHERE u.username = :username";

}
