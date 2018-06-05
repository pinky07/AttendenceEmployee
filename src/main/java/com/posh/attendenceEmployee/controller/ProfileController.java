package com.posh.attendenceEmployee.controller;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.posh.attendenceEmployee.model.Profile;
import com.posh.attendenceEmployee.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	
	@Autowired
	private ProfileService profileService;
	
	private final Logger LOG = LoggerFactory.getLogger(ProfileController.class);
	
	@RequestMapping(value={"/get"},method=RequestMethod.GET)
	public ModelAndView getAll(Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profilesList",profileService.findAll() );
		model.addAttribute("profile",new Profile());
		modelAndView.setViewName("profiles");
		return modelAndView;
	}
	
	@RequestMapping(value={"/get/{id}"},method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id,Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profilesList",profileService.findById(id));
		modelAndView.addObject("ErrorMessage", "Could not found profile");
		model.addAttribute("profile",new Profile());
		modelAndView.setViewName("profiles");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView profileGet( @ModelAttribute("profile") Profile profile) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profileView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView profileAdd(@Valid  @ModelAttribute("profile") Profile profile, BindingResult bindingResult) {
			ModelAndView modelAndView = new ModelAndView();
			if(profile.getId()!=0){
				modelAndView.addObject("Message", "profile has been Updated successfully");
			}
			profileService.saveProfile(profile);
			modelAndView.addObject("Message", "profile has been added successfully!");
			modelAndView.setViewName("redirect:/profile/get");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView profileUpdate(@PathVariable("id") int id,Model model) {
		
		LOG.info("profile/update/{id} getting profile with id: {}", id);
			ModelAndView modelAndView = new ModelAndView("profileView");
			 Profile profile=profileService.findById(id);
			modelAndView.addObject("profile",profile);
			model.addAttribute("pageTitle", "Update Page");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") int id){
		LOG.info("profile/delete/{id} getting profile with id: {}", id);
		ModelAndView modelAndView = new ModelAndView();
		Profile  profile =profileService.findById(id);
		if(profile ==null){
			modelAndView.addObject("Message", "profile not found");
		}
		profileService.deleteById(id);
	  return new ModelAndView("redirect:/profile/get");
	 }
}
