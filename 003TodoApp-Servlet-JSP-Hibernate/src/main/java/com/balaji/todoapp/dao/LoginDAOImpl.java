package com.balaji.todoapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.balaji.todoapp.bean.User;
import com.balaji.todoapp.quries.TodoQueries;
import com.balaji.todoapp.util.SessionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isUserValid(String username, String password) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery(TodoQueries.LOGIN_QUERY);
		query.setParameter("username", username);
		query.setParameter("password", password);
		Long count = (Long) query.uniqueResult();
		System.out.println("Count : "+count);
		SessionUtil.close(session);
		return count == 0 ? false : true;
	}

	@Override
	public void deleteByUsername(String username) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery(TodoQueries.DELETE_LOGIN_QUERY);
		query.setParameter("username", username);
		query.executeUpdate();
		SessionUtil.close(session);
	}

	@Override
	public void addUser(User user) {
		Session session = SessionUtil.getSession();
		Transaction transaction =session.beginTransaction();
		session.save(user);
		transaction.commit();
		SessionUtil.close(session);
	}

}
