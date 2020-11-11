package com.balaji.todoapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.quries.TodoQueries;
import com.balaji.todoapp.util.SessionUtil;

public class TodoDAOImpl implements TodoDAO {

	@Override
	public List<Todo> retrieveTodos() {
		Session session = SessionUtil.getSession();
		List<Todo> todos = session.createCriteria(Todo.class).list();
		SessionUtil.close(session);
		return todos;
	}

	@Override
	public void addTodo(Todo todo) {
		Session session = SessionUtil.getSession();
		Transaction transaction =session.beginTransaction();
		session.save(todo);
		transaction.commit();
		SessionUtil.close(session);
	}

	@Override
	public void deleteTodo(Integer todoId) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery(TodoQueries.DELETE_TODO_QUERY);
		query.setParameter("id", todoId);
	    query.executeUpdate();
		SessionUtil.close(session);
	}

}
