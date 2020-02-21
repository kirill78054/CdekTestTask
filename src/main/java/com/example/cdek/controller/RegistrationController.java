package com.example.cdek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cdek.model.UserProf;
import com.example.cdek.repository.UserReposImpl;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserReposImpl userReposImpl;

	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String role,
			Map<String, Object> model) {
		String userFromDb = userReposImpl.findOne(username);
		if (userFromDb != null) {
			model.put("message", "Пользователь с таким логином уже существует!");
			return "registration";
		}
		if (username.equals("") || password.equals("")) {
			model.put("message", "Вы заполнили не все поля");
			return "registration";
		}
		UserProf user = new UserProf(null, username, password, role);
		user.setActive(true);
		userReposImpl.add(user);
		return "redirect:/login";
	}

}
