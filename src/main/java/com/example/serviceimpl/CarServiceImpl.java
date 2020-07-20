package com.example.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Cars;
import com.example.repository.CarsRepository;
import com.example.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarsRepository carsRepository;

	@Override
	public List<Cars> getCars() {
		/*
		List<Cars> vehicle = new ArrayList<Cars>();
		vehicle.add(new Cars(1, 4, "BV-40-TIC", "SKODA", "12$/day"));
		vehicle.add(new Cars(2, 2, "BV-10-KJG", "BMW", "15$/day"));
		vehicle.add(new Cars(3, 4, "BV-42-DMC", "TESLA", "23$/day"));
		vehicle.add(new Cars(4, 2, "BV-21-TOC", "NISSAN", "16$/day"));
		vehicle.add(new Cars(5, 4, "AG-45-XSA", "TOYOTA", "17$/day"));
		vehicle.add(new Cars(6, 2, "DB-67-DAC", "BUGATTI", "18$/day"));
		vehicle.add(new Cars(7, 4, "IL-99-COD", "DACIA", "11$/day"));
		vehicle.add(new Cars(8, 4, "IL-98-DOC", "RENAULT", "12$/day"));
		vehicle.add(new Cars(9, 2, "AG-63-ABY", "VOLSKWAGEN", "25$/day"));
		vehicle.add(new Cars(10, 2, "MM-21-DON", "OPEL", "14$/day"));
*/
	
		return carsRepository.findAll();
	}

	@Override
	public int saveCars(Cars car) {
		int x = 5;
		return x;

	}

	@Override
	public int updateCars(Cars car) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCars(int carId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Cars> getCarsById(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
