package com.mindtree.coe.bugtracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.coe.bugtracker.dto.BugDto;
import com.mindtree.coe.bugtracker.dto.BugDtoListDto;
import com.mindtree.coe.bugtracker.dto.NewBug;
import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.entity.Status;
import com.mindtree.coe.bugtracker.service.Service;
import com.mindtree.coe.bugtracker.serviceimpl.ServiceImpl;

@Controller
public class FrontController {
	Service serviceImpl = null;
	Employee employee = null;

	@RequestMapping("/")
	public String showWelcome(ModelAndView model) {
		System.out.println("Inside Controller");
		model.addObject("msg", "Hiiiii....");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String userName = request.getParameter("user-name");
		String userPassword = request.getParameter("user-password");

		serviceImpl = new ServiceImpl();
		employee = serviceImpl.login(userName, userPassword);
		if (employee != null) {
			switch (employee.getRole()) {
			case "user": {
							model.addObject("employee", employee);
							model.setViewName(employee.getRole() + "Page");
						};
						break;
			case "support":{
							model.addObject("employee", employee);
							model.setViewName(employee.getRole() + "Page");
						};
						break;
			case "admin": {
							BugDtoListDto bugDtoListDto;
							bugDtoListDto=serviceImpl.getAllBugs();
							model.addObject("bugDtoListDto",bugDtoListDto);
							model.addObject("supportList", serviceImpl.getAllSupportList());
							model.setViewName(employee.getRole() + "Page");
			}
			default:{}
			}

			model.addObject("employee", employee);
			model.setViewName(employee.getRole() + "Page");
		} else {
			System.out.println("Login not SuccessFull");
			model.setViewName("index");
		}
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
		System.out.println(bug.toString());
		model.addObject("employee", employee);
		model.setViewName(employee.getRole() + "Page");
		return model;
	}
	
	@RequestMapping(value="/assignBugs",method = RequestMethod.POST)
	public ModelAndView assignBugs(@ModelAttribute("bugDtoListDto") BugDtoListDto bugDtoListDto){
		System.out.println("sdad");
		System.out.println(bugDtoListDto.getBugDtoList().size());
		return new ModelAndView("index");
		
	}
}
