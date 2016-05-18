package com.mindtree.coe.bugtracker.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "Bug_seq",sequenceName = "Bug_sequence" ,allocationSize = 1, initialValue = 1)
public class Bug {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Bug_seq")
	private long id;
	@Column
	private String title;
	@Column
	private String desciption;
	@Column(name = "startTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date submittedDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee submittedBy;
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee supportedBy;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Bug() {
		super();
	}

	public Bug(String title, String desciption, Date submittedDate, Employee submittedBy, Status status) {
		super();
		this.title = title;
		this.desciption = desciption;
		this.submittedDate = submittedDate;
		this.submittedBy = submittedBy;
		this.status = status;
	}

	public Bug(long id, String title, String desciption, Date submittedDate, Employee submittedBy, Employee supportedBy,
			Status status) {
		super();
		this.id = id;
		this.title = title;
		this.desciption = desciption;
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

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
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

	@Override
	public String toString() {
		return "Bug [id=" + id + ", title=" + title + ", desciption=" + desciption + ", submittedDate=" + submittedDate
				+ ", submittedBy=" + submittedBy.getName() + ", supportedBy=" + supportedBy + ", status=" + status + "]";
	}

}
