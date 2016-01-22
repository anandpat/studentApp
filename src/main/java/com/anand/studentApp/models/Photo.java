package com.anand.studentApp.models;

import java.sql.Blob;

public class Photo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String userName;
	private Blob image;

	public Photo() {
	}

	public Photo(Blob image) {
		this.image = image;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Blob getImage() {
		return this.image;
	}

	public void setImage(Blob bFile) {
		this.image = bFile;
	}

}