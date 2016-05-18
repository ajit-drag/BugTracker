package com.mindtree.coe.bugtracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "Employee_seq",sequenceName = "Employee_sequence",allocationSize=1,initialValue=1) 
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Employee_seq")
	private long id;
	@Column
	private String name;
	@Column
	private String role;
	@Column
	private String password; 
	public Employee() {
	 super();
	}
	public Employee(String name, String role, String password) {
		super();
		this.name = name;
		this.role = role;
		this.password = password;
	}
	public Employee(long id, String name, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
