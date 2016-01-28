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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((skillRequired == null) ? 0 : skillRequired.hashCode());
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
		SkillForJob other = (SkillForJob) obj;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (skillRequired == null) {
			if (other.skillRequired != null)
				return false;
		} else if (!skillRequired.equals(other.skillRequired))
			return false;
		return true;
	}
	
	
	
}
