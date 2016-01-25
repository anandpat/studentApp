package com.anand.studentApp.hibernate.dao;

import java.util.List;

import com.anand.studentApp.models.Notification;
import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.Role;
import com.anand.studentApp.models.SubjectSchedule;
import com.anand.studentApp.models.User;

public interface StudentDao {

	public User getUser(String userName);

	public void insertUser(User user);
	
	public boolean forgotPassChange(PasswordChange passwordChange);
	
	public void changePassword(String username, String newPassword);
	
	public void updateUser(User user);
	
	public List<User> getAllStudents();
	
	public List<User> getAllTeachers();
	
	public List<User> getAllTPO();
	
	public void addNewUser(User newUser);
	
	public List<SubjectSchedule> getAllSubjectForTeacher(String userName);
	
	public void addNotification(Notification notification );
	
	public int getnotificationCount(Role role);
}
