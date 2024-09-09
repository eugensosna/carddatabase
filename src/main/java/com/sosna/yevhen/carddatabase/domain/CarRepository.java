package com.sosna.yevhen.carddatabase.domain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import org.slf4j.*;
import com.sosna.yevhen.carddatabase.domain.Car;
import com.sosna.yevhen.carddatabase.domain.*;


public interface CarRepository extends CrudRepository<Car, Long>{
	
	// Fetch cars by brand
	List<Car> findByBrand(String brand);
	// Fetch cars by color
	List<Car> findByColor(String color);
	// Fetch cars by model year
	List<Car> findByModelYear(int modelYear);
	// Filter by brand and model
	
	List<Car> findByBrandAndModel(String brand, String model);
	// Fetch cars by brand or color
	List<Car> findByBrandOrColor(String brand, String color);
	
	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.model = ?1")
	List<Car> findByModel(String model);
	
	
	
	
}



