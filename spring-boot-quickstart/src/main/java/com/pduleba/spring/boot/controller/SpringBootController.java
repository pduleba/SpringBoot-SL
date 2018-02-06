package com.pduleba.spring.boot.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.pduleba.spring.boot.model.RestResponse;

@Controller
public class SpringBootController {

	@RequestMapping(method = RequestMethod.GET, path = "/controller", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public RestResponse controller(@RequestParam(value = "name", defaultValue = "controller") String name) {
		return new RestResponse(name);
	}


}
