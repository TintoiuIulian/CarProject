package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Garage;



public interface GarageService {
	
	public List<Garage> getGarage();

	public int saveGarage(Garage garage);

	public int updateGarage(Garage garage);

	public int deleteGarage(int garageId);

	public Optional<Garage> getGarageById(int garageId);

}
