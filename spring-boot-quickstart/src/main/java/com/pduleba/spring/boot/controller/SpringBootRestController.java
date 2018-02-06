package com.pduleba.spring.boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.pduleba.spring.boot.model.RestResponse;

// Alternative for @Controller + @ResponseBody
@RestController
public class SpringBootRestController {

	@RequestMapping(method = RequestMethod.GET, path = "/restController", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public RestResponse restController(@RequestParam(value = "name", defaultValue = "restController") String name) {
		return new RestResponse(name);
	}


}
