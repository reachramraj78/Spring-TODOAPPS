package com.balaji.todoapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		// Creating Hibernate SessionFactory Instance
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void close(Session session) {
		if (sessionFactory != null) {
			session.close();
		}
	}

}
