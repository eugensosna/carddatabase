package com.sosna.yevhen.carddatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.sosna.yevhen.carddatabase.web.CarController;

@SpringBootTest
class CarddatabaseApplicationTests {
	@Autowired
	private CarController controller;

	@Test
	//@DisplayName("First example test case1")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	

}
