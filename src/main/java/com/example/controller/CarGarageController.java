package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Cars;
import com.example.model.Garage;
import com.example.repository.CarsRepository;
import com.example.service.CarService;
import com.example.service.GarageService;

@Controller
public class CarGarageController {

	@Autowired
	public GarageService garageService;

	@Autowired
	public CarService carService;

	@Autowired
	CarsRepository automobileService;

	@RequestMapping(value = "/OverviewPage", method = RequestMethod.GET)
	public ModelAndView OverviewPageRequestMapping(final HttpServletRequest request, final HttpServletResponse response,
			final HttpSession session, final Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from OverviewPageRequestMapping");

		List<Cars> vehicle = carService.getCars();

		model.addAttribute("carList", vehicle);
		carService.getCars();

		List<Garage> garage = garageService.getGarage();
		

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
