package com.mindtree.coe.bugtracker.dao;

import java.util.List;

import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;

public interface Dao {
	Employee login(String userName,String userPassword);
	Employee getEmployee(Employee employee);
	Bug submitBug(Bug bug);
	List<Bug> getAllBugs();
	List<Employee> getAllSupportList();
	Bug getBug(long bugId);
	Employee getSupportEmployee(long supportEmployeeId);
	int assignBugs(List<Bug> assignedBugList);
}
