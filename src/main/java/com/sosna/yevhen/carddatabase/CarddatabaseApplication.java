package com.sosna.yevhen.carddatabase;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sosna.yevhen.carddatabase.domain.Car;
import com.sosna.yevhen.carddatabase.domain.CarRepository;
import com.sosna.yevhen.carddatabase.domain.Owner;
import com.sosna.yevhen.carddatabase.domain.OwnerRepository;

@SpringBootApplication
public class CarddatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CarddatabaseApplication.class);
	private final CarRepository repository;
	private final OwnerRepository orepository;


	public CarddatabaseApplication(CarRepository repository, 
			OwnerRepository orepository) {
		this.repository = repository;
		this.orepository = orepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarddatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO: test many to many 55
		
		Owner owner1 = new Owner("John", "Johnson");
		orepository.save(owner1);
		
		repository.save(new Car("Ford", "Mustang", "Redd", "Ob-1027", 2015, 5900, owner1));
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner1));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000,owner1));
		
		//Fetch all cars
		for(Car car: repository.findAll()) {
			
			logger.info("brand:{} , model :{}",car.getBrand(), car.getModel());
			
		}

	}
}
