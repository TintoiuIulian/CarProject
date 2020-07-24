package com.example.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Car;
import com.example.repository.CarsRepository;
import com.example.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarsRepository carRepository;

	@Override
	public List<Car> getCars() {
		/*
		 * List<Cars> vehicle = new ArrayList<Cars>(); vehicle.add(new Cars(1, 4,
		 * "BV-40-TIC", "SKODA", "12$/day")); vehicle.add(new Cars(2, 2, "BV-10-KJG",
		 * "BMW", "15$/day")); vehicle.add(new Cars(3, 4, "BV-42-DMC", "TESLA",
		 * "23$/day")); vehicle.add(new Cars(4, 2, "BV-21-TOC", "NISSAN", "16$/day"));
		 * vehicle.add(new Cars(5, 4, "AG-45-XSA", "TOYOTA", "17$/day"));
		 * vehicle.add(new Cars(6, 2, "DB-67-DAC", "BUGATTI", "18$/day"));
		 * vehicle.add(new Cars(7, 4, "IL-99-COD", "DACIA", "11$/day")); vehicle.add(new
		 * Cars(8, 4, "IL-98-DOC", "RENAULT", "12$/day")); vehicle.add(new Cars(9, 2,
		 * "AG-63-ABY", "VOLSKWAGEN", "25$/day")); vehicle.add(new Cars(10, 2,
		 * "MM-21-DON", "OPEL", "14$/day"));
		 */

		return carRepository.findAll();
	}

	@Override
	public void saveCars(Car car) {
		carRepository.save(car);
	}

	@Override
	public int updateCars(Car car) {
		return carRepository.save(car).getId();
	}

	@Override
	public Optional<Car> getCarsById(int carId) {

		return carRepository.findById(carId);

	}

	@Override
	public int deleteCars(int carId) {

		return 0;
	}

	@Override
	public void deleteById(int carId) {

		carRepository.deleteById(carId);

	}

}
