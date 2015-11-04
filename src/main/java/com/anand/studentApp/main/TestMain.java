package com.anand.studentApp.main;


import com.anand.studentApp.hibernate.dao.StudentDaoImpl;
import com.anand.studentApp.models.Branch;
import com.anand.studentApp.models.ContactInfo;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.Sex;
import com.anand.studentApp.models.User;

public class TestMain {

	public static void main(String[] args) {
		StudentDaoImpl dao= new StudentDaoImpl();
		User user= new User();
		user.setBranch(Branch.CS);
		user.setUserName("anand248");
		user.setPassword("ahss");
		user.setRole(Role.STUDENT);
		user.setSex(Sex.MALE);
		
		ContactInfo contactInfo= new ContactInfo();
		contactInfo.setHomePhone("2344333");
		contactInfo.setMobileNum("23443223");
		contactInfo.setParentName("ram");
		contactInfo.setPrimaryAdd("bina");
		contactInfo.setSecondaryAdd("bangalore");
		contactInfo.setUser(user);
		user.setContactInfo(contactInfo);
	    dao.insertUser(user);
	}
}
