package com.example.controller;

import java.util.List;
import java.util.Optional;

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

	@RequestMapping(value = "/CarRegistration", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView CarRegistrationRequestMapping(@ModelAttribute String formAction,
			final HttpServletRequest request, final HttpServletResponse response, final HttpSession session,
			final Model model, final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView();
		System.out.println("Hello from CarRegistrationRequestMapping");
		System.out.println("formAction: " + formAction);
		Car car = new Car();
		model.addAttribute(car);

		mav.setViewName("CarRegistration");
		return mav;

	}

	@RequestMapping(value = "/submitCarRegistration", method = RequestMethod.POST)
	public ModelAndView CarRegistrationRequestMapping(@ModelAttribute("car") Car car, final HttpServletRequest request,
			final HttpServletResponse response, final HttpSession session, final Model model,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		String formAction = request.getParameter("formAction");
		System.out.println("Hello from submitCarRegistration");
		int result;
		if ("updateCars".equals(formAction)) {
			result = carService.updateCars(car);
		} else {
			 carService.saveCars(car);
		}

		mav.setViewName("redirect:/OverviewPage");
		return mav;

	}

	@RequestMapping(value = "/updateCars", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView updateCars(@RequestParam("carId") int id, Model model) {

		ModelAndView mav = new ModelAndView();
		Optional<Car> car = carService.getCarsById(id);
		System.out.println("hello from updateCar");
		System.out.println(car);
		model.addAttribute("car", car);
		model.addAttribute("formAction", "updateCars");
		mav.setViewName("CarRegistration");
		return mav;
	}

	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
	public ModelAndView deleteCar(@RequestParam("carId") int id) {

		ModelAndView mav = new ModelAndView();
		Optional<Car> car = carService.getCarsById(id);
		carService.deleteById(id); // asta realizeaza stergerea
		mav.setViewName("redirect:/OverviewPage");
		return mav;
	}

}
