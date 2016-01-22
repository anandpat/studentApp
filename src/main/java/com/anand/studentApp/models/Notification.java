package com.anand.studentApp.models;

public class Notification {

	private int notificationId;
	private NotificationFor notificationFor;
	private String notification;

	public int getNotificationId() {
		return notificationId;
	}

	public Notification(){
		
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public NotificationFor getNotificationFor() {
		return notificationFor;
	}

	public void setNotificationFor(NotificationFor notificationFor) {
		this.notificationFor = notificationFor;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
}
