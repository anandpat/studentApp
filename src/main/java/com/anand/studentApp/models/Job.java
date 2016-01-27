package com.anand.studentApp.models;

public class Job {
private String jobId;
private String compId;
private String positionName;
private String YOP;
private int minPersentange;
private SkillForJob skillsRequied;
private double sal;
private Status Status;
private String contactNo;

public String getJobId() {
	return jobId;
}
public void setJobId(String jobId) {
	this.jobId = jobId;
}
public String getPositionName() {
	return positionName;
}
public void setPositionName(String positionName) {
	this.positionName = positionName;
}
public String getYOP() {
	return YOP;
}
public void setYOP(String yOP) {
	YOP = yOP;
}
public int getMinPersentange() {
	return minPersentange;
}
public void setMinPersentange(int minPersentange) {
	this.minPersentange = minPersentange;
}

public SkillForJob getSkillsRequied() {
	return skillsRequied;
}
public void setSkillsRequied(SkillForJob skillsRequied) {
	this.skillsRequied = skillsRequied;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public Status getStatus() {
	return Status;
}
public void setStatus(Status status) {
	Status = status;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getCompId() {
	return compId;
}
public void setCompId(String compId) {
	this.compId = compId;
}
	
}
