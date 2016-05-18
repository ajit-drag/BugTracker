package com.mindtree.coe.bugtracker.dao;

import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;

public interface Dao {
	Employee login(String userName,String userPassword);
	Bug submitBug(Bug bug);
}
