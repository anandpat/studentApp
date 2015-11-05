package com.anand.studentApp.models;

public class Department {
	Branch branch;
	String  hod; // userName of the User who is HOD of the perticular dept

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getHod() {
		return hod;
	}

	public void setHod(String hod) {
		this.hod = hod;
	}

	
}
