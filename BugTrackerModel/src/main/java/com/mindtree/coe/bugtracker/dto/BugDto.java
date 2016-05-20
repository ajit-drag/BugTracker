package com.mindtree.coe.bugtracker.dto;

import java.util.Date;

import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.entity.Status;

public class BugDto {
	private long id;
	private String title;
	private String description;
	private Date submittedDate;
	private Employee submittedBy;
	private String supportedById;
	private Status status;

	public BugDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Employee getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Employee submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getSupportedById() {
		return supportedById;
	}

	public void setSupportedById(String supportedById) {
		this.supportedById = supportedById;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BugDto [id=" + id + ", title=" + title + ", description=" + description + ", submittedDate="
				+ submittedDate + ", submittedBy=" + submittedBy + ", supportedById=" + supportedById + ", status="
				+ status + "]";
	}
	
}
