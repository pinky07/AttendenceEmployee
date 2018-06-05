package com.posh.attendenceEmployee.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.posh.attendenceEmployee.model.Holiday;
import com.posh.attendenceEmployee.service.HolidayService;

@Controller
@RequestMapping("/holiday")
public class HolidayController {

	@Autowired
	private HolidayService holidayService;
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public ModelAndView registration(Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("holidayList",holidayService.findAll() );
		modelAndView.setViewName("HolidayList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView payrollGet( @ModelAttribute("holiday") Holiday holiday,Model model) {
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("holiday", new Holiday());
		modelAndView.setViewName("HolidayForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView payrollAdd(@Valid  @ModelAttribute("holiday") Holiday holiday, BindingResult bindingResult) {
			ModelAndView modelAndView = new ModelAndView();
			if(holiday.getId()!=0){
				modelAndView.addObject("Message", "holiday has been Updated successfully");
			}
			holidayService.saveHoliday(holiday);
			modelAndView.setViewName("redirect:/holiday/get");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView payrollUpdate(@PathVariable("id") int id,Model model) {
			ModelAndView modelAndView = new ModelAndView("HolidayForm");
			Holiday holiday=holidayService.findById(id);
			modelAndView.addObject("holiday",holiday);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		Holiday holiday =holidayService.findById(id);
		if(holiday ==null){
			modelAndView.addObject("Message", "holiday not found");
		}
		holidayService.deleteById(id);
	  return new ModelAndView("redirect:/holiday/get");
	 }
}
