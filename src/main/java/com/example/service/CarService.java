package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Car;

public interface CarService {

	public List<Car> getCars();

	public void saveCars(Car car);

	public int updateCars(Car car);

	public int deleteCars(int carId);

	public Optional<Car> getCarsById(int carId);

	public void deleteById(int carId);
	



}
