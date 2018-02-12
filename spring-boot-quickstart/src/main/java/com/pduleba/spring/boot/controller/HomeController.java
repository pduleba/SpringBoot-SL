package com.pduleba.spring.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "App home is ready!";
	}

}
