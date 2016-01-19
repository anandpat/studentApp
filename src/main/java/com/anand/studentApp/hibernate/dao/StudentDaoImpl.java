package com.anand.studentApp.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anand.studentApp.controllers.HomeController;
import com.anand.studentApp.hibernate.util.HibernateUtil;
import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.User;

public class StudentDaoImpl implements StudentDao {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public User getUser(String userName) {
		logger.info("getUser start username : {}",userName);
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userName);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public void insertUser(User user) {

	}

	@Override
	public boolean forgotPassChange(PasswordChange passwordChange) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		PasswordChange change = (PasswordChange) session.get(PasswordChange.class, passwordChange.getUserName());

		if (change != null && passwordChange.getQuestion().equalsIgnoreCase(change.getQuestion().trim())
				&& passwordChange.getAnswer().equals(change.getAnswer())) {
			changePassword(change.getUserName(), "12345");
			session.getTransaction().commit();
			logger.info("password for {} has been changed  to 12345",change.getUserName() );
			return true;
		}
		return false;
	}

	@Override
	public void changePassword(String username, String newPassword) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, username);

		user.setPassword(newPassword);
		session.merge(user);
		session.getTransaction().commit();

	}

}
