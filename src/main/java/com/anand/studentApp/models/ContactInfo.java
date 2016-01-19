package com.anand.studentApp.models;

public class ContactInfo {

	private User user;
	private String userName;
	private String parentName;
	private String primaryAdd;
	private String secondaryAdd;
	private String homePhone;
	private String MobileNum;

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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPrimaryAdd() {
		return primaryAdd;
	}

	public void setPrimaryAdd(String primaryAdd) {
		this.primaryAdd = primaryAdd;
	}

	public String getSecondaryAdd() {
		return secondaryAdd;
	}

	public void setSecondaryAdd(String secondaryAdd) {
		this.secondaryAdd = secondaryAdd;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobileNum() {
		return MobileNum;
	}

	public void setMobileNum(String mobileNum) {
		MobileNum = mobileNum;
	}

	@Override
	public String toString() {
		return "ContactInfo [user=" + user + ", userName=" + userName + ", parentName=" + parentName + ", primaryAdd="
				+ primaryAdd + ", secondaryAdd=" + secondaryAdd + ", homePhone=" + homePhone + ", MobileNum="
				+ MobileNum + "]";
	}
}
