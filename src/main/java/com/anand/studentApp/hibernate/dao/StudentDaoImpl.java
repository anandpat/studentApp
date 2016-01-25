package com.anand.studentApp.hibernate.dao;

import java.util.Iterator;
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
import com.anand.studentApp.models.Book;
import com.anand.studentApp.models.BookIssue;
import com.anand.studentApp.models.ContactInfo;
import com.anand.studentApp.models.Notification;
import com.anand.studentApp.models.NotificationFor;
import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.SubjectSchedule;
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

	@Override
	public void addNewUser(User newUser) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("addNewUser() userData: {} ",newUser );
		
		session.save(newUser);
		session.getTransaction().commit();
		
	}

	@Override
	public List<SubjectSchedule> getAllSubjectForTeacher(String userName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("getAllSubjectForTeacher()");
		
		Criteria criteria= session.createCriteria(SubjectSchedule.class) ;
		criteria.add(Restrictions.eq("teacher", userName));
		List<SubjectSchedule> subjectList= (List<SubjectSchedule>)criteria.list();
		logger.info("getAllSubjectForTeacher() reslut list count {}", subjectList.size());
		
		session.getTransaction().commit();
		return subjectList;
	}

	@Override
	public void addNotification(Notification notification) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		logger.info("addNotification()  for {} with message {} ",notification.getNotificationFor(),notification.getNotification() );
		
		session.save(notification);
		session.getTransaction().commit();
		
	}

	@Override
	public int getnotificationCount(Role role) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int countStudent=0;
		int countTeacher=0;
		int countCollege=0;
		int countAll=0;
		
		Criteria criteria= session.createCriteria(Notification.class) ;
		List<Notification> notificationList= (List<Notification>)criteria.list();
		
		for (Iterator iterator = notificationList.iterator(); iterator.hasNext();) {
			Notification notification = (Notification) iterator.next();
			if(notification.getNotificationFor().equals(Enum.valueOf(NotificationFor.class, "STUDENT"))){
				countStudent++;
				countCollege++;
				countAll++;
			} else if(notification.getNotificationFor().equals(Enum.valueOf(NotificationFor.class, "TEACHER"))){
				countTeacher++;
				countCollege++;
				countAll++;
			} else if(notification.getNotificationFor().equals(Enum.valueOf(NotificationFor.class, "COLLEGE"))){
				countStudent++;
				countTeacher++;
				countCollege++;
				countAll++;
			}else{
				countStudent++;
				countTeacher++;
				countCollege++;
				countAll++;
			}
			
		}
		session.getTransaction().commit();
		
		if(role.equals(Enum.valueOf(Role.class, "STUDENT"))){
			return countStudent;
		}else if(role.equals(Enum.valueOf(Role.class, "TEACHER"))){
			return countTeacher;
		} else if(role.equals(Enum.valueOf(Role.class, "TPO"))){
			return countCollege;
		} else 
		return countAll;
	}

	@Override
	public List<Book> getbookList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria= session.createCriteria(Book.class) ;
		List<Book> bookList= (List<Book>)criteria.list();
		return bookList;
	}

	@Override
	public void registerForBook(String bookId, String userName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Book book= (Book) session.get(Book.class, bookId);
		book.setIsAvailable('N');
		
		session.merge(book);
		
		BookIssue bookIssue= new BookIssue();
		bookIssue.setBookId(bookId);
		bookIssue.setUserName(userName);
		
		session.save(bookIssue);
		
		
		//session.save(bookIssue);
		session.getTransaction().commit();
	}

	

	

}
