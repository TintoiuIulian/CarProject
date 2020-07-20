package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Cars;

public interface CarService {

	public List<Cars> getCars();

	public int saveCars(Cars car);

	public int updateCars(Cars car);

	public int deleteCars(int carId);

	public Optional<Cars> getCarsById(int carId);

}
