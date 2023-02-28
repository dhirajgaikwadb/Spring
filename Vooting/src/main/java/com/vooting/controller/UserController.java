package com.vooting.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vooting.Repository.UserRepo;
import com.vooting.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	private void userDetails(Model model, Principal p) {
		
		String username = p.getName();
		UserModel user = userRepo.findByUsername(username);
		model.addAttribute("userm", user);

	}

	@GetMapping("/")
	public String home() {
		return "user/home";
	}
	
}
