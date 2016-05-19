package com.mindtree.coe.bugtracker.dto;

import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.entity.Status;

public class BugDto {
	private long id;
	private String title;
	private String description;
	private String submittedDate;
	private Employee submittedBy;
	private Employee supportedBy;
	private Status status;
	public BugDto() {
		super();
	}
	public BugDto(long id, String title, String description, String submittedDate, Employee submittedBy,
			Employee supportedBy, Status status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.submittedDate = submittedDate;
		this.submittedBy = submittedBy;
		this.supportedBy = supportedBy;
		this.status = status;
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
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public Employee getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(Employee submittedBy) {
		this.submittedBy = submittedBy;
	}
	public Employee getSupportedBy() {
		return supportedBy;
	}
	public void setSupportedBy(Employee supportedBy) {
		this.supportedBy = supportedBy;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
