package com.sosna.yevhen.carddatabase.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosna.yevhen.carddatabase.domain.Car;
import com.sosna.yevhen.carddatabase.domain.CarRepository;

@RestController
public class CarController {
	private final CarRepository repository;
	public CarController(CarRepository repo) {
		this.repository = repo;
	}
	
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		return repository.findAll();
	}

}
