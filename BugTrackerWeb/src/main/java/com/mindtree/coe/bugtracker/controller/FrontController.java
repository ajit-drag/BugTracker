package com.mindtree.coe.bugtracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.coe.bugtracker.entity.Bug;
import com.mindtree.coe.bugtracker.entity.Employee;
import com.mindtree.coe.bugtracker.service.Service;
import com.mindtree.coe.bugtracker.serviceimpl.ServiceImpl;

import dto.NewBug;

@Controller
public class FrontController {
	Service serviceImpl=null;
	Employee employee=null;
	
	@RequestMapping("/")
	public String showWelcome(ModelAndView model){
		System.out.println("Inside Controller");
		model.addObject("msg", "Hiiiii....");
		return "index";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String userName = request.getParameter("user-name");
		String userPassword = request.getParameter("user-password");
		
		serviceImpl = new ServiceImpl();
		employee = serviceImpl.login(userName, userPassword);
		if(employee!=null){
			System.out.println("Login SuccessFull");
			System.out.println(employee.getRole());
			model.addObject("employee", employee);
			model.setViewName(employee.getRole()+"Page");
		}else{
			System.out.println("Login not SuccessFull");
			model.setViewName("index");
		}
		return model;
	}
	
	@RequestMapping(value="/submitBug",method = RequestMethod.POST)
	public Bug submitBug(HttpServletRequest request){
		NewBug newBug = new NewBug();
		serviceImpl = new ServiceImpl();
		newBug.setTitle(request.getParameter("bug-title"));
		newBug.setDescription(request.getParameter("bug-description"));
		newBug.setSubmittedBy(employee);
		Bug bug=serviceImpl.submitBug(newBug);
		System.out.println(bug.toString());
		return bug;
		}
}
