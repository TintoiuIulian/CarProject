package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Car;

public interface CarsRepository extends JpaRepository<Car, Integer> {

	/*
	 * @Modifying
	 * 
	 * @Query("delete from Car where id=:id") public int deleteById(@Param("id") int
	 * id);
	 * 
	 * @Query("select e from Car e WHERE e.brand=:brand AND e.rentingprice=:rentingprice"
	 * ) public Car getByBrandAndRentingprice(String brand, String rentingprice);
	 * 
	 * @Query("select  from Car") public List<Car> cars();
	 */

}
