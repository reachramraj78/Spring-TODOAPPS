package com.balaji.todoapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.balaji.todoapp.bean.User;
import com.balaji.todoapp.dao.LoginDAO;
import com.balaji.todoapp.dao.LoginDAOImpl;

/**
 * Application Lifecycle Listener implementation class CreateLoginUserListener
 *
 */
@WebListener
public class CreateLoginUserListener implements ServletContextListener {

	private LoginDAO loginDAO = new LoginDAOImpl();

	/**
	 * Default constructor.
	 */
	public CreateLoginUserListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
       loginDAO.deleteByUsername("balaji");
       User user = new User();
       user.setUsername("balaji");
       user.setPassword("balaji");
       loginDAO.addUser(user);
	}

}
