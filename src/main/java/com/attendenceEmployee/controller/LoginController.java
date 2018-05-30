package com.attendenceEmployee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.posh.attendenceEmployee.model.Employee;
import com.posh.attendenceEmployee.service.EmployeeService;

@Controller
public class LoginController {

	

	@Autowired
	private EmployeeService userService;
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		Employee user = new Employee();
		modelAndView.addObject(user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Employee user,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		Employee userExists = userService.findUserByUserName(user.getUserName());
		if(userExists!=null){
			bindingResult.rejectValue("email", "user.error","There is already a user registered with the email provided");
		}
		if(bindingResult.hasErrors()){
			modelAndView.setViewName("registration");
		}
		else{
			userService.saveUser(user);
			modelAndView.addObject("successMessage","User has been registered successfully");
			modelAndView.addObject("user",new Employee());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}
	@RequestMapping(value="/admin/home",method = RequestMethod.GET)
	public ModelAndView home(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee user = userService.findUserByUserName(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " );
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}
