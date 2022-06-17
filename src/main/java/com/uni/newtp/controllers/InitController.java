package com.uni.newtp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
	
	@GetMapping( value = "/" )
	public String init() {
		return "Hola Mundo";
	}
}
