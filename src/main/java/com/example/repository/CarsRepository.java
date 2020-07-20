package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Integer> {

	@Modifying
	@Query("delete from Cars where id=:id")
	public int deleteById(@Param("id") int id);

	@Query("select e from Cars e WHERE e.brand=:brand AND e.rentingprice=:rentingprice")
	public Cars getByBrandAndRentingprice(String brand, String rentingprice);

}
