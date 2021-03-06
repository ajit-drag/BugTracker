package com.mindtree.coe.bugtracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.coe.bugtracker.dto.BugDtoListDto;
import com.mindtree.coe.bugtracker.dto.BugSupportDto;
import com.mindtree.coe.bugtracker.dto.BugSupportDtoListDto;
import com.mindtree.coe.bugtracker.dto.NewBug;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.service.Service;
import com.mindtree.coe.bugtracker.serviceimpl.EntityToDto;
import com.mindtree.coe.bugtracker.serviceimpl.ServiceImpl;

@Controller
public class FrontController {
	Service serviceImpl = null;
	Employee employee = null;
	String userName;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		serviceImpl = new ServiceImpl();
		employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("inside controller");
		EntityToDto entityToDto = new EntityToDto();
		if (employee != null) {
			switch (employee.getRole()) {
			case "ROLE_USER": {
				model.addObject("employee", employee);
				model.setViewName("userPage");
			}
				;
				break;
			case "ROLE_SUPPORT": {
				model.addObject("employee", employee);
				BugSupportDtoListDto bugSupportDtoListDto = entityToDto.mapBugListToBugSupportDtoListDto(employee.getSupportBugList());
				model.addObject("bugSupportDtoListDto", bugSupportDtoListDto);
				model.setViewName("supportPage");
			}
				;
				break;
			case "ROLE_ADMIN": {
				BugDtoListDto bugDtoListDto;
				bugDtoListDto = serviceImpl.getAllBugs();
				model.addObject("bugDtoListDto", bugDtoListDto);
				List<Employee> supportList = serviceImpl.getAllSupportList();
				System.out.println(supportList);
				model.addObject("supportList", supportList);
				model.setViewName("adminPage");
			}
			default: {
			}
			}
		} else {
			System.out.println("Login not SuccessFull");
			model.setViewName("index");
		}

		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}

	@RequestMapping(value = "/submitBug", method = RequestMethod.POST)
	public ModelAndView submitBug(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		NewBug newBug = new NewBug();
		serviceImpl = new ServiceImpl();
		newBug.setTitle(request.getParameter("bug-title"));
		newBug.setDescription(request.getParameter("bug-description"));
		newBug.setSubmittedBy(employee);
		Bug bug = serviceImpl.submitBug(newBug);
		model.addObject("message", "Bug detail successfully submitted. And will appear in bug status in next login.");
		model.addObject("employee", employee);
		model.setViewName("userPage");
		return model;
	}

	@RequestMapping(value = "/assignBugs", method = RequestMethod.POST)
	public ModelAndView assignBugs(@ModelAttribute("bugDtoListDto") BugDtoListDto bugDtoListDto) {
		ModelAndView model = new ModelAndView();
		int bugsAssigned = 0;
		serviceImpl = new ServiceImpl();
		bugsAssigned = serviceImpl.assignBugs(bugDtoListDto);
		if (bugsAssigned != 0) {
			model.addObject("message", bugsAssigned + " bugs assigned.");
		}
		bugDtoListDto = serviceImpl.getAllBugs();
		model.addObject("employee", employee);
		model.addObject("bugDtoListDto", bugDtoListDto);
		model.addObject("supportList", serviceImpl.getAllSupportList());
		model.setViewName("adminPage");
		return model;

	}

	@RequestMapping(value = "/assignBugStatus", method = RequestMethod.POST)
	ModelAndView assignBugStatus(@ModelAttribute("bugSupportDtoListDto") BugSupportDtoListDto bugSupportDtoListDto) {
		ModelAndView model = new ModelAndView();
		serviceImpl = new ServiceImpl();
		int isDone = serviceImpl.assignBugStatus(bugSupportDtoListDto);
		EntityToDto entityToDto = new EntityToDto();
		employee = serviceImpl.getEmployee(employee);
		bugSupportDtoListDto = entityToDto.mapBugListToBugSupportDtoListDto(employee.getSupportBugList());
		model.addObject("employee", employee);
		model.addObject("bugSupportDtoListDto", bugSupportDtoListDto);
		model.addObject("message", "Bugs resolved successfully.");
		model.setViewName("supportPage");
		return model;

	}
}
