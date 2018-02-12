package com.pduleba.spring.boot.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.mockito.*;

import com.pduleba.spring.boot.model.Shipwreck;
import com.pduleba.spring.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	private ShipwreckRepository repo;
	private ShipwreckController service;

	@Before
	public void beforeAllTests() {
		// alternative for @RunWith(MockitoJUnitRunner.class)
		MockitoAnnotations.initMocks(this);
		repo = Mockito.mock(ShipwreckRepository.class);
		service = new ShipwreckController(repo);
	}

	@Test
	public void testRead() throws Exception {
		// given
		final Long EXPECTED_ID = Long.valueOf(1L);
		Shipwreck expected = new Shipwreck(EXPECTED_ID, "Yamato", "Japanese battleship", "Good", 100, 45D, 45D, 2000);

		// when
		when(repo.findOne(EXPECTED_ID)).thenReturn(expected);
		Shipwreck result = service.read(EXPECTED_ID);

		// then

		// Mockito assert style
		verify(repo).findOne(Mockito.eq(EXPECTED_ID));
		// JUnit assert style
		assertEquals(expected, result);
		// Hamcrest assert style
		MatcherAssert.assertThat(result, org.hamcrest.Matchers.is(expected));
	}

}
