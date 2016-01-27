package com.anand.studentApp.models;

import java.util.List;
import java.util.Set;

public class SkillForJob {
	private Job job;
	private String jobId;
	private Set<Skill> skillRequired;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public Set<Skill> getSkillRequired() {
		return skillRequired;
	}
	public void setSkillRequired(Set<Skill> skillRequired) {
		this.skillRequired = skillRequired;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
}
