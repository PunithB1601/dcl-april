package com.dcl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demo")
	public String demo() {
		return "This is OAuth2.0 github testing";
	}
}
