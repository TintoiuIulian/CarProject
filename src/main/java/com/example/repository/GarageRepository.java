package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Garage;

public interface GarageRepository extends JpaRepository<Garage, Integer> {

}
