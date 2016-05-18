package com.mindtree.coe.bugtracker.service;

import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;

import dto.NewBug;

public interface Service {
	Employee login(String userName,String userPassword);
	Bug submitBug(NewBug newBug);

}
