package com.dcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.service.OpenAIService;

@Controller
public class AIController {

	@Autowired
	private OpenAIService service;
	
	@GetMapping("/get")
	public String ui(Model model) {
		return "chats";
	}
	
	@PostMapping("/resp")
	public String response(@RequestParam String question, Model model) {
		String resp=service.chat(question);
		model.addAttribute("question",question);
		model.addAttribute("response",resp);
		return "chats";
	}

}
