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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Status == null) ? 0 : Status.hashCode());
	result = prime * result + ((YOP == null) ? 0 : YOP.hashCode());
	result = prime * result + ((compId == null) ? 0 : compId.hashCode());
	result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
	result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
	result = prime * result + minPersentange;
	result = prime * result + ((positionName == null) ? 0 : positionName.hashCode());
	long temp;
	temp = Double.doubleToLongBits(sal);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((skillsRequied == null) ? 0 : skillsRequied.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Job other = (Job) obj;
	if (Status != other.Status)
		return false;
	if (YOP == null) {
		if (other.YOP != null)
			return false;
	} else if (!YOP.equals(other.YOP))
		return false;
	if (compId == null) {
		if (other.compId != null)
			return false;
	} else if (!compId.equals(other.compId))
		return false;
	if (contactNo == null) {
		if (other.contactNo != null)
			return false;
	} else if (!contactNo.equals(other.contactNo))
		return false;
	if (jobId == null) {
		if (other.jobId != null)
			return false;
	} else if (!jobId.equals(other.jobId))
		return false;
	if (minPersentange != other.minPersentange)
		return false;
	if (positionName == null) {
		if (other.positionName != null)
			return false;
	} else if (!positionName.equals(other.positionName))
		return false;
	if (Double.doubleToLongBits(sal) != Double.doubleToLongBits(other.sal))
		return false;
	if (skillsRequied == null) {
		if (other.skillsRequied != null)
			return false;
	} else if (!skillsRequied.equals(other.skillsRequied))
		return false;
	return true;
}

	
}
