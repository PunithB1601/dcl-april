package com.dcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcl.entity.User;
import com.dcl.service.UserService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	@GetMapping("/welcome")
	public String addEmployee(Model model) {
		model.addAttribute("user",new User());
		return "addUser";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Validated  @ModelAttribute User user, BindingResult result,Model model) {
		//BindingResult : It is a interface which captures the result of validation.
		if(result.hasErrors()) { 
			return "addUser";
		}
		
		user=uservice.addUser(user);
		model.addAttribute("success","User - "+user.getUserId()+" has been added to Database!");
		return "addUser";
	}
	
	@GetMapping("/get")
	public String viewAllUser(Model model) {
		List<User> userList=uservice.findAll();
		model.addAttribute("userList",userList);
		return "viewUser";
	}
	
	@GetMapping("/getById/{userId}")
	public String getById(@PathVariable Integer userId,Model model) {
		User user=uservice.getById(userId);
		model.addAttribute("user", user);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute User user, Model model) {
		uservice.updateUser(user);
		model.addAttribute("success","Account updated successfully");
		return "redirect:/user/get";
	}
	
	
	@GetMapping("/delete/{userId}")
	public String delete(@PathVariable Integer userId, Model model) {
		uservice.deleteUser(userId);
		model.addAttribute("success","Data with userId "+userId+" deleted");
		return "redirect:/user/get";
	}
	
	

}
