package com.posh.attendenceEmployee.controller;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.posh.attendenceEmployee.model.Payroll;
import com.posh.attendenceEmployee.service.EmployeeService;
import com.posh.attendenceEmployee.service.PayrollService;

@Controller
@RequestMapping("/payroll")
public class PayrollController {

	
	@Autowired
	private PayrollService payrollService;
	@Autowired
	
	private EmployeeService employeeService;
	
	
	private final Logger LOG = LoggerFactory.getLogger(PayrollController.class);
	
	@RequestMapping(value={"/get"},method=RequestMethod.GET)
	public ModelAndView getAll(Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("payrollsList",payrollService.findAll() );
		model.addAttribute("payroll",new Payroll());
		modelAndView.setViewName("payrolles");
		return modelAndView;
	}
	
	@RequestMapping(value={"/get/{id}"},method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id,Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("payrollsList",payrollService.findById(id));
		modelAndView.addObject("ErrorMessage", "Could not found payroll");
		model.addAttribute("payroll",new Payroll());
		modelAndView.setViewName("payrolles");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView payrollGet( @ModelAttribute("payroll") Payroll payroll,Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("payrollView");
		modelAndView.addObject("employee", employeeService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView payrollAdd(@Valid  @ModelAttribute("payroll") Payroll payroll, BindingResult bindingResult,RedirectAttributes redirectAttrs) {
			ModelAndView modelAndView = new ModelAndView();
			if(payroll.getId()!=0){
				modelAndView.addObject("Message", "payroll has been Updated successfully");
			}
			payrollService.savePayroll(payroll);
			//modelAndView.addObject("Message", "payroll has been added successfully!");
			redirectAttrs.addFlashAttribute("successMsg", "Account Edit/Delete successfully");
			modelAndView.setViewName("redirect:/payroll/get");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView payrollUpdate(@PathVariable("id") int id,Model model) {
		
		LOG.info("payroll/update/{id} getting payroll with id: {}", id);
			ModelAndView modelAndView = new ModelAndView("payrollView");
			Payroll payroll=payrollService.findById(id);
			modelAndView.addObject("payroll",payroll);
			model.addAttribute("pageTitle", "Update Page");
			modelAndView.addObject("employee", employeeService.findAll());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		LOG.info("payroll/delete/{id} getting payroll with id: {}", id);
		ModelAndView modelAndView = new ModelAndView();
		Payroll  payroll =payrollService.findById(id);
		if(payroll ==null){
			modelAndView.addObject("Message", "payroll not found");
		}
		payrollService.deleteById(id);
	  return new ModelAndView("redirect:/payroll/get");
	 }
}
