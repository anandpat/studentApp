package com.anand.studentApp.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anand.studentApp.hibernate.util.HibernateUtil;
import com.anand.studentApp.models.User;

public class StudentDaoImpl implements StudentDao {

	private  SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	@Override
	public User getUser(String userName) {
		
		return null;
	}

	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		System.out.println("useer inserted!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		session.getTransaction().commit();
		
	}

}
