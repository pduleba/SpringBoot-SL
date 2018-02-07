package com.pduleba.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // includes @EnableAutoConfiguration
public class App {

	// How to ::
	// Configuration:
	// Header :: Accept=application/json :: produces JSON as output
	// Header :: Accept=application/xml :: produces XML as output
	//
	// 1. Request with no parameter
	// http://localhost:8080/controller
	// http://localhost:8080/controller.xml
	// http://localhost:8080/controller?mediaType=xml
	// http://localhost:8080/restController
	// http://localhost:8080/restController.xml
	// http://localhost:8080/restController?mediaType=xml
	//
	// 2. Request with parameter
	// http://localhost:8080/controller?name=abc
	// http://localhost:8080/controller.xml?name=xyz
	// http://localhost:8080/controller?name=xyz&mediaType=xml
	// http://localhost:8080/restController?name=xyz
	// http://localhost:8080/restController.xml?name=xyz
	// http://localhost:8080/restController?name=xyz&mediaType=xml

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
