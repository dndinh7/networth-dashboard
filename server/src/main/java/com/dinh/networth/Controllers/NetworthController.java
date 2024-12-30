package com.dinh.networth.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This should be the API endpoints for the home page
 */

@RestController
public class NetworthController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}