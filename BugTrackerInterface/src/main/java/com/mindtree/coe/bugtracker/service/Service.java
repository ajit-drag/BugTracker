package com.mindtree.coe.bugtracker.service;

import java.util.List;

import com.mindtree.coe.bugtracker.dto.BugDto;
import com.mindtree.coe.bugtracker.dto.BugDtoListDto;
import com.mindtree.coe.bugtracker.dto.NewBug;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;

public interface Service {
	Employee login(String userName,String userPassword);
	Bug submitBug(NewBug newBug);
	BugDtoListDto getAllBugs();
	List<Employee> getAllSupportList();
}
