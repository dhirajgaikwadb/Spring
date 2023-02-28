package com.vooting.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vooting.model.UserModel;
import com.vooting.service.vootservice;

@Controller
public class vootController {

	@Autowired
	private vootservice service;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login(Model model) {
		UserModel userm = new UserModel();
		model.addAttribute("userm", userm);
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		UserModel userm = new UserModel();
		model.addAttribute("userm", userm);
		return "register";
	}

	@PostMapping("/save")
	public String createuser(@ModelAttribute UserModel user, HttpSession session) {

		// System.out.println(user);

		boolean f = service.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
			return "login";
		}

		else {
			UserModel userm = service.saveData(user);
			if (userm != null) {
				session.setAttribute("msg", "Register Sucessfully");
				return "login";
			} else {
				session.setAttribute("msg", "Something wrong on server");
				return "redirect:/register";
			}
		}

		
	}
}
