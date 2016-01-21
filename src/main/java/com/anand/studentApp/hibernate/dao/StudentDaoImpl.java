package com.anand.studentApp.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anand.studentApp.controllers.HomeController;
import com.anand.studentApp.hibernate.util.HibernateUtil;
import com.anand.studentApp.models.ContactInfo;
import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.User;

public class StudentDaoImpl implements StudentDao {
	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public User getUser(String userName) {
		logger.info("getUser start username : {}", userName);
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userName);

		if (user != null) {
			/*
			 * ContactInfo contactInfo =(ContactInfo)
			 * session.get(ContactInfo.class, userName);
			 * user.setContactInfo(contactInfo);
			 */
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
			logger.info("password for {} has been changed  to 12345", change.getUserName());
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

	@Override
	public void updateUser(User updateUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("update user data {}", updateUser);
		session.saveOrUpdate(updateUser);

		session.getTransaction().commit();

	}

	@Override
	public List<User> getAllStudents() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("getAllStudents()");
		Criteria criteria= session.createCriteria(User.class) ;
		criteria.add(Restrictions.eq("role", Enum.valueOf(Role.class, "STUDENT")));
		List<User> res=(List<User>) criteria.list();
		logger.info("getAllStudents() reslut list count {}", res.size());
		
		session.getTransaction().commit();
		return res;
	}

	@Override
	public List<User> getAllTeachers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("getAllTeachers()");
		
		Criteria criteria= session.createCriteria(User.class) ;
		criteria.add(Restrictions.eq("role", Enum.valueOf(Role.class, "TEACHER")));
		List<User> res=(List<User>) criteria.list();
		logger.info("getAllTeachers() reslut list count {}", res.size());
		session.getTransaction().commit();
		return res;
	}

	@Override
	public List<User> getAllTPO() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("getAllTPO()");
		
		Criteria criteria= session.createCriteria(User.class) ;
		criteria.add(Restrictions.eq("role", Enum.valueOf(Role.class, "TPO")));
		List<User> res=(List<User>) criteria.list();
		logger.info("getAllTPO() reslut list count {}", res.size());
		
		session.getTransaction().commit();
		return res;
	}

}
