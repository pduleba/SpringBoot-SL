package com.pduleba.spring.boot;

import org.junit.*;

import com.pduleba.spring.boot.controller.HomeController;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "com.pduleba.spring.boot" })
public class HomeControllerTest {

	@Test
	public void testHome() {
		HomeController hc = new HomeController();
		Assert.assertEquals("App home is ready!", hc.home());
	}

}
