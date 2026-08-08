package com.dcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/login1")
	public String login() {
		return "login-page";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dash-board";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout-page";
	}
	
	@GetMapping("/contact")
	public String contactUs() {
		return "contact-us";
	}
	
	
}
