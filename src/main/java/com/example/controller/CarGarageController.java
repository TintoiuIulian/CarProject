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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Car;
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

		List<Car> vehicles = carService.getCars();

		model.addAttribute("carList", vehicles);

		// List<Garage> garage = garageService.getGarage();

		mav.setViewName("OverviewPage");
		return mav;
	}

	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
	public ModelAndView deleteCar(@RequestParam("carId") int carId) {

		ModelAndView mav = new ModelAndView();

		carService.deleteById(carId);

		mav.setViewName("redirect:/OverviewPage");
		return mav;
	}

	@RequestMapping(value = "/CarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping(Model model) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from CarRegistrationRequestMapping");

		Car car = new Car();
		model.addAttribute("car", car);

		mav.setViewName("CarRegistration");
		return mav;

	}

	@RequestMapping(value = "/submitCarRegistration", method = RequestMethod.GET)
	public ModelAndView CarRegistrationRequestMapping(@ModelAttribute Car car) {
		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from submitCarRegistration");
		// Save car to database
		// int result = carService.saveCars(car);
		// System.out.println("Result: " + result);

		mav.setViewName("redirect:/OverviewPage");
		return mav;

	}
}
