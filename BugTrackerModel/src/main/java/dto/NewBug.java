package dto;

import com.mindtree.coe.bugtracker.entity.Employee;

public class NewBug {
	private String title;
	private String description;
	private Employee submittedBy;

	public NewBug() {
		super();
	}

	public NewBug(String title, String description, Employee submittedBy) {
		super();
		this.title = title;
		this.description = description;
		this.submittedBy = submittedBy;
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

	public Employee getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Employee submittedBy) {
		this.submittedBy = submittedBy;
	}

}
