package com.posh.attendenceEmployee.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.posh.attendenceEmployee.model.Attendence;
import com.posh.attendenceEmployee.model.Employee;
import com.posh.attendenceEmployee.model.Profile;
import com.posh.attendenceEmployee.service.AttendenceService;
import com.posh.attendenceEmployee.service.EmployeeService;
import com.posh.attendenceEmployee.service.ProfileService;


@Controller
public class LoginController {

	

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private AttendenceService attendenceService;

	@Autowired
	private ProfileService profileService;
	
	java.util.Date date=new java.util.Date();  
	
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public ModelAndView homePage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(Model model){
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("profilesList",profileService.findAll() );
		model.addAttribute("profile",new Profile());
		model.addAttribute("employee",new Employee());
		model.addAttribute("profilesList",profileService.findAll());
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid  @ModelAttribute("employee") Employee employee,@ModelAttribute("profile") Profile profile, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Employee userExists = empService.findUserByUserName(employee.getUserName());
		if (userExists != null) {
			bindingResult
					.rejectValue("UserName", "error.user",
							"There is already a user registered with the UserName provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			empService.saveUser(employee);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new Employee());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/attendence", method = RequestMethod.POST)
	public ModelAndView createNewUser(@RequestParam String userName){
		ModelAndView modelAndView = new ModelAndView();
		
		{
			Employee emp =empService.findUserByUserName(userName);
			Attendence atten1=attendenceService.findByEmployee(emp.getId());
			if(atten1.getStartTime()==null){
				
				atten1.setStartTime(date);
			}if((atten1.getStartTime()!= null) && (atten1.getEndTime()==null)){
				atten1.setEndTime(date);
			}
			Attendence atten = new Attendence();	
			atten.setEmployee(emp);
			modelAndView.addObject("successMessage","Attendece has been  successfully save");
			
		}
		return modelAndView;
	}
	@RequestMapping(value="/admin/home",method = RequestMethod.GET)
	public ModelAndView home(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = empService.findUserByUserName(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", "Welcome " + employee.getName() + " " );
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	 public ModelAndView list(){
		 ModelAndView model = new ModelAndView("list");
		List<Employee>employeeList = empService.findAll();
		  model.addObject("employeeList", employeeList); 
		  	return model;
		}

	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable("id") int id){
	  ModelAndView model = new ModelAndView("registration");
	  Employee employee = empService.findById(id);
	  model.addObject("employee", employee);
	  return model;
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		 empService.deleteById(id);
	  return new ModelAndView("redirect:/list");
	 }
}
