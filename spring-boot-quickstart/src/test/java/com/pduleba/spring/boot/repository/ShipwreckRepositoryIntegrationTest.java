package com.pduleba.spring.boot.repository;

import java.util.List;

import org.hamcrest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pduleba.spring.boot.App;
import com.pduleba.spring.boot.model.Shipwreck;

@ActiveProfiles("test") // application-test.properties file
@RunWith(SpringJUnit4ClassRunner.class)
// How to configure and start Spring Application Context - similar to main()
// BEFORE SPRING BOOT 1.5 it was @IntegrationTest
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.NONE)
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	private ShipwreckRepository repository;

	@Test
	public void testFindAll() {
		List<Shipwreck> result = repository.findAll();
		MatcherAssert.assertThat(result.size(), Matchers.greaterThanOrEqualTo(0));
	}

}
