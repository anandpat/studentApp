package com.anand.studentApp.hibernate.dao;

import com.anand.studentApp.models.PasswordChange;
import com.anand.studentApp.models.User;

public interface StudentDao {

	public User getUser(String userName);

	public void insertUser(User user);
	
	public boolean forgotPassChange(PasswordChange passwordChange);
	
	public void changePassword(String username, String newPassword) ;
}
