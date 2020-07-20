package com.example.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Garage;
import com.example.repository.GarageRepository;
import com.example.service.GarageService;

@Service
public class GarageServiceImpl implements GarageService {

	@Autowired
	GarageRepository garageRepository;

	@Override
	public List<Garage> getGarage() {
		// TODO Auto-generated method stub
		return garageRepository.findAll();
	}

	@Override
	public int saveGarage(Garage garage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGarage(Garage garage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGarage(int garageId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Garage> getGarageById(int garageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
