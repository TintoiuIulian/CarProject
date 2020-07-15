package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarGarageController {

	@RequestMapping(value = "/OverviewPage", method = RequestMethod.GET)
	public ModelAndView OverviewPageRequestMapping() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from OverviewPageRequestMapping");
		mav.setViewName("OverviewPage");
		return mav;
	}

	@RequestMapping(value = "/CarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from CarRegistrationRequestMapping");
		mav.setViewName("CarRegistration");
		return mav;

	}

}
