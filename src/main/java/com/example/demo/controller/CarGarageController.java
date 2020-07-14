package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CarGarageController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView helloRequestMapping() {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from helloRequestMapping");
		mav.setViewName("OverviewPage");
		return mav;
	}

}
