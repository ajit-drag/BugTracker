package com.mindtree.coe.bugtracker.dto;

import java.util.Date;

public class BugSupportDto {
	private long id;
	private String title;
	private String description;
	private Date date;
	private String submittedBy;
	private String isResolved;

	public BugSupportDto() {
		super();
	}

	public BugSupportDto(long id, String title, String description, Date date, String submittedBy, String isResolved) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.submittedBy = submittedBy;
		this.isResolved = isResolved;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getIsResolved() {
		return isResolved;
	}

	public void setIsResolved(String isResolved) {
		this.isResolved = isResolved;
	}

}
