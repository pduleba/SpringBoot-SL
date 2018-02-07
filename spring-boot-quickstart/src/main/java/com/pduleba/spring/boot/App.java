package com.pduleba.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // includes @EnableAutoConfiguration
public class App {

	private static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

	public static void main(String[] args) {
		// System.setProperty(SPRING_PROFILES_ACTIVE, "test");
		System.setProperty(SPRING_PROFILES_ACTIVE, "dev");
		// System.setProperty(SPRING_PROFILES_ACTIVE, "prod");
		SpringApplication.run(App.class, args);
	}


}
