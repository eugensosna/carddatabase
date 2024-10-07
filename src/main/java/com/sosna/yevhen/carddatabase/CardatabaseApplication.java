package com.sosna.yevhen.carddatabase;

import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sosna.yevhen.carddatabase.domain.AppUser;
import com.sosna.yevhen.carddatabase.domain.AppUserRepository;
import com.sosna.yevhen.carddatabase.domain.Car;
import com.sosna.yevhen.carddatabase.domain.CarRepository;
import com.sosna.yevhen.carddatabase.domain.Owner;
import com.sosna.yevhen.carddatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	private final CarRepository repository;
	private final OwnerRepository orepository;
	private final AppUserRepository urepository;

	public CardatabaseApplication(CarRepository repository, OwnerRepository orepository, AppUserRepository urepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.urepository = urepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {

		if (repository.findByModel("Mustang").size() <= 0) {
			Owner owner1 = new Owner("Mary", "Robinson");
			orepository.save(owner1);

			repository.save(new Car("Ford", "Mustang", "Redd", "Ob-1027", 2015, 5900, owner1));
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner1));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner1));
		}
		// Username: user, password: user
		urepository.save(new AppUser("user",
		"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		// Username: admin, password: admin
		urepository.save(new AppUser("admin",
		"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));

		// Fetch all cars
		for (Car car : repository.findAll()) {
			logger.info("brand:{} , model :{}", car.getBrand(), car.getModel());

		}
	}

}
