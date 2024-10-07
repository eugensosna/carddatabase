package com.sosna.yevhen.carddatabase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.
DataJpaTest;
import org.junit.jupiter.api.Test;
import com.sosna.yevhen.carddatabase.domain.*;

@DataJpaTest
class OwnerRepositoryTest {
	
	@Autowired
	private OwnerRepository repository;
	
	@Test
	void saveOwner() {
		repository.save(new Owner("Lucy", "Smithd"));
		assertThat(repository.findByFirstname("Lucy")).isPresent();
	}
	@Test
	void deleteOwners() {
	repository.save(new Owner("Lisa", "Morrison"));
	repository.deleteAll();
	assertThat(repository.count()).isEqualTo(0);
	}



}
