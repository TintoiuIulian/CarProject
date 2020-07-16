package com.example.controller;

import java.util.ArrayList;
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
		String text = "vreau sa afisez o inregistrare a masinii";
		model.addAttribute("mytext", text);

		List<Cars> cars = new ArrayList<Cars>();
		cars.add(new Cars(1, 4, "BV-40-TIC", "SKODA"));
		cars.add(new Cars(2, 2, "BV-10-KJG", "BMW"));
		cars.add(new Cars(3, 4, "BV-42-DMC", "TESLA"));
		cars.add(new Cars(4, 2, "BV-21-TOC", "NISSAN"));
		model.addAttribute("carsList", cars);

		carService.getCars();

		mav.setViewName("OverviewPage");
		return mav;
	}

	@RequestMapping(value = "/CarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping(Model model) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from CarRegistrationRequestMapping");

		Cars car = new Cars();

		model.addAttribute("cartitle", car);
		mav.setViewName("CarRegistration");
		return mav;

	}

	@RequestMapping(value = "/submitCarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping(@ModelAttribute Cars car) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from submitCarRegistration");
		int result = carService.saveCars(car);
		System.out.println("Result: " + result );

		mav.setViewName("redirect:/OverviewPage");
		return mav;

	}
}
