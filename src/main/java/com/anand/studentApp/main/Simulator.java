package com.anand.studentApp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anand.studentApp.hibernate.util.HibernateUtil;
import com.anand.studentApp.models.Branch;
import com.anand.studentApp.models.ContactInfo;
import com.anand.studentApp.models.Department;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.Sex;
import com.anand.studentApp.models.SubjectSchedule;
import com.anand.studentApp.models.User;

public class Simulator {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {
		addStudents();
		addTeachers();
		addAdmin();
		addTpo();
		addDepartments();
		addSubjectSchedule();
	}

	// 25 students 5 in each branch
	public static void addStudents() {
		for (int i = 1; i <= 25; i++) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			User user = new User();

			if (i <= 5) {
				user.setBranch(Branch.CS);
			} else if (i > 5 && i <= 10) {
				user.setBranch(Branch.IT);
			} else if (i > 10 && i <= 15) {
				user.setBranch(Branch.EC);
			} else if (i > 15 && i <= 20) {
				user.setBranch(Branch.EE);
			} else if (i > 20 && i <= 25) {
				user.setBranch(Branch.ME);
			}
			user.setUserName("Student" + i);
			user.setPassword("std" + i);
			user.setFullName("Student " + i);
			user.setRole(Role.STUDENT);
			if(i<12){
			user.setSex(Sex.MALE);
			}else 
				user.setSex(Sex.FEMALE);
			ContactInfo contactInfo = new ContactInfo();
			contactInfo.setHomePhone("124578555" + i);
			contactInfo.setMobileNum("23443223" + i);
			contactInfo.setParentName("parent" + i);
			contactInfo.setPrimaryAdd("pramaryAdd" + i);
			contactInfo.setSecondaryAdd("SecondaryAdd" + i);
			contactInfo.setUser(user);
			user.setContactInfo(contactInfo);
			session.persist(user);

			session.getTransaction().commit();

		}

	}

	// 5 teacher
	public static void addTeachers() {
		for (int i = 1; i <= 5; i++) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			User user = new User();

			user.setBranch(Branch.COMMON);

			user.setUserName("teacher" + i);
			user.setPassword("tea" + i);
			user.setFullName("Teacher " + i);
			user.setRole(Role.TEACHER);
			if(i<3){
			user.setSex(Sex.MALE);
			}else 
				user.setSex(Sex.FEMALE);	
			ContactInfo contactInfo = new ContactInfo();
			contactInfo.setHomePhone("124578345" + i);
			contactInfo.setMobileNum("23443233" + i);
			contactInfo.setParentName("Tparent" + i);
			contactInfo.setPrimaryAdd("TpramaryAdd" + i);
			contactInfo.setSecondaryAdd("TSecondaryAdd" + i);
			contactInfo.setUser(user);
			user.setContactInfo(contactInfo);
			session.persist(user);

			session.getTransaction().commit();
		}

	}

	// 2 admin users
	public static void addAdmin() {
		for (int i = 1; i <= 2; i++) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			User user = new User();

			user.setBranch(Branch.COMMON);

			user.setUserName("admin" + i);
			user.setPassword("adm" + i);
			user.setFullName("Admin " + i);
			user.setRole(Role.ADMIN);
			if(i<2){
			user.setSex(Sex.MALE);
			}else 
				user.setSex(Sex.FEMALE);	
			ContactInfo contactInfo = new ContactInfo();
			contactInfo.setHomePhone("124578345" + i);
			contactInfo.setMobileNum("23443233" + i);
			contactInfo.setParentName("Aparent" + i);
			contactInfo.setPrimaryAdd("ApramaryAdd" + i);
			contactInfo.setSecondaryAdd("ASecondaryAdd" + i);
			contactInfo.setUser(user);
			user.setContactInfo(contactInfo);
			session.persist(user);

			session.getTransaction().commit();
		}
	}

	// 1 tpo
	public static void addTpo() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setBranch(Branch.COMMON);
		user.setUserName("tpo1");
		user.setPassword("tpo1");
		user.setFullName("TPO ");
		user.setRole(Role.TPO);
		user.setSex(Sex.MALE);
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setHomePhone("124578345" );
		contactInfo.setMobileNum("23443233");
		contactInfo.setParentName("TPparent");
		contactInfo.setPrimaryAdd("TPpramaryAdd");
		contactInfo.setSecondaryAdd("TPSecondaryAdd");
		contactInfo.setUser(user);
		user.setContactInfo(contactInfo);
		session.persist(user);

		session.getTransaction().commit();
	}

	// 5 departments and 1 hod for each department (must be a teacher)
	public static void addDepartments() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Department department1= new Department();
		department1.setBranch(Branch.CS);
		department1.setHod("teacher1");
		
		
		Department department2= new Department();
		department2.setBranch(Branch.EC);
		department2.setHod("teacher2");
		
		Department department3= new Department();
		department3.setBranch(Branch.EE);
		department3.setHod("teacher3");
		
		Department department4= new Department();
		department4.setBranch(Branch.IT);
		department4.setHod("teacher4");
		
		Department department5= new Department();
		department5.setBranch(Branch.ME);
		department5.setHod("teacher5");
		
		session.save(department1);
		session.save(department2);
		session.save(department3);
		session.save(department4);
		session.save(department5);
		
		session.getTransaction().commit();
	}

	// add subject schedule (5 subject per branch)
	public static void addSubjectSchedule() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i=1;i<=5 ;i++){
			SubjectSchedule schedule = new SubjectSchedule();
			schedule.setSubjectCode("IT-10"+i);
			schedule.setSubjectName("IT-Sub"+i);
			schedule.setBranch(Branch.IT);
			schedule.setTeacher("teacher"+i);
			session.save(schedule);
		}
		
		for(int i=1;i<=5 ;i++){
			SubjectSchedule schedule = new SubjectSchedule();
			schedule.setSubjectCode("EC-10"+i);
			schedule.setSubjectName("EC-Sub"+i);
			schedule.setBranch(Branch.EC);
			schedule.setTeacher("teacher"+i);
			session.save(schedule);
		}
		
		for(int i=1;i<=5 ;i++){
			SubjectSchedule schedule = new SubjectSchedule();
			schedule.setSubjectCode("ME-10"+i);
			schedule.setSubjectName("ME-Sub"+i);
			schedule.setBranch(Branch.ME);
			schedule.setTeacher("teacher"+i);
			session.save(schedule);
		}
		
		for(int i=1;i<=5 ;i++){
			SubjectSchedule schedule = new SubjectSchedule();
			schedule.setSubjectCode("CS-10"+i);
			schedule.setSubjectName("CS-Sub"+i);
			schedule.setBranch(Branch.CS);
			schedule.setTeacher("teacher"+i);
			session.save(schedule);
		}
		
		for(int i=1;i<=5 ;i++){
			SubjectSchedule schedule = new SubjectSchedule();
			schedule.setSubjectCode("EE-10"+i);
			schedule.setSubjectName("EE-Sub"+i);
			schedule.setBranch(Branch.EE);
			schedule.setTeacher("teacher"+i);
			session.save(schedule);
		}
		
		session.getTransaction().commit();
		
		
	}

}
