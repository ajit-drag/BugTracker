package com.mindtree.coe.bugtracker.service;

import java.util.List;

import com.mindtree.coe.bugtracker.dto.BugDto;
import com.mindtree.coe.bugtracker.dto.BugDtoListDto;
import com.mindtree.coe.bugtracker.dto.BugSupportDtoListDto;
import com.mindtree.coe.bugtracker.dto.NewBug;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;

/**
 * @author M1036033
 *
 */
/**
 * @author M1036033
 *
 */
/**
 * @author M1036033
 *
 */
public interface Service {
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	Employee login(String userName,String userPassword);
	/**
	 * @param newBug
	 * @return
	 */
	Bug submitBug(NewBug newBug);
	/**
	 * @return
	 */
	BugDtoListDto getAllBugs();
	/**
	 * @return
	 */
	List<Employee> getAllSupportList();
	
	/**This function will assign the support person to each bug.Done by Admin
	 * @param bugDto
	 * @return It will return the number successful assigned bugs  
	 */
	int assignBugs(BugDtoListDto bugDtoListDto);
	
	
	/** this method will assign status of bugs. done by respective support person.
	 * @param bugSupportDtoListDto
	 * @return Status whether bug is assigned or not.
	 */
	int assignBugStatus(BugSupportDtoListDto bugSupportDtoListDto);
}
