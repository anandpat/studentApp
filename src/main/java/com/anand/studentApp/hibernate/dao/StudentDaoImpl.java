package com.anand.studentApp.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anand.studentApp.hibernate.util.HibernateUtil;
import com.anand.studentApp.models.Branch;
import com.anand.studentApp.models.Department;
import com.anand.studentApp.models.User;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public User getUser(String userName) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userName);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		// to add in department
		Department department1 = new Department();
		department1.setBranch(Branch.IT);
		department1.setHod(user.getUserName());

		session.persist(department1);
		System.out.println("useer inserted!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		session.getTransaction().commit();

	}

}
