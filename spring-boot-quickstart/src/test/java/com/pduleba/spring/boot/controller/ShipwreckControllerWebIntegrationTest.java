package com.pduleba.spring.boot.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pduleba.spring.boot.App;
import com.pduleba.spring.boot.model.Shipwreck;

@ActiveProfiles("test") // application-test.properties file
@RunWith(SpringJUnit4ClassRunner.class)
// How to configure and start Spring Application Context - similar to main()
// BEFORE SPRING BOOT 1.5 it was @WebIntegrationTest
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {

	private final Long id = 1L;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testReadAsBO() throws Exception {
		// given

		// when
		restTemplate.getForObject("http://localhost:8080/api/v1/shipwrecks/{id}", Shipwreck.class,
				id);

		// then
	}

	@Test
	public void testReadAsString() throws Exception {
		// given

		// when
		restTemplate.getForObject("http://localhost:8080/api/v1/shipwrecks/{id}", String.class, id);

		// then
	}

	@Test
	public void testReadAsResponseEntity() throws Exception {
		// given

		// when
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks",
				String.class);

		// then
		assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
		assertThat(response.getBody(), is(notNullValue()));
	}
}
