package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Cars;
import com.example.service.CarService;

@Controller
public class CarGarageController {

	@Autowired
	public CarService carService;

	@RequestMapping(value = "/OverviewPage", method = RequestMethod.GET)
	public ModelAndView OverviewPageRequestMapping(Model model) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from OverviewPageRequestMapping");

		List<Cars> vehicle = carService.getCars();
		model.addAttribute("carList", vehicle);
		carService.getCars();

		// Read all employees from database

		mav.setViewName("OverviewPage");
		return mav;
	}

	@RequestMapping(value = "/CarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping(Model model) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from CarRegistrationRequestMapping");

		Cars car = new Cars();
		model.addAttribute("car", car);

		mav.setViewName("CarRegistration");
		return mav;

	}

	@RequestMapping(value = "/submitCarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping(@ModelAttribute Cars car) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from submitCarRegistration");
		// Save car to database
		// int result = carService.saveCars(car);
		// System.out.println("Result: " + result);

		mav.setViewName("redirect:/OverviewPage");
		return mav;

	}
}
