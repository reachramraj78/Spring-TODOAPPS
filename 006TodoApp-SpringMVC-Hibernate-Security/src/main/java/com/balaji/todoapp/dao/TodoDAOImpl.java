package com.balaji.todoapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.balaji.todoapp.bean.Todo;
import com.balaji.todoapp.quries.TodoQueries;

@Repository
public class TodoDAOImpl implements TodoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Todo> retrieveTodos() {
		Session session = sessionFactory.openSession();
		List<Todo> todos = session.createCriteria(Todo.class).list();
		session.close();
		return todos;
	}

	@Override
	public void addTodo(Todo todo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(todo);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteTodo(Integer todoId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(TodoQueries.DELETE_TODO_QUERY);
		query.setParameter("id", todoId);
		query.executeUpdate();
		session.close();
	}

}
