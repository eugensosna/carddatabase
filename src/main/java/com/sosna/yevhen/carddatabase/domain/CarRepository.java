package com.sosna.yevhen.carddatabase.domain;
import org.springframework.data.repository.CrudRepository;

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
}
