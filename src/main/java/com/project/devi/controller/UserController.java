package com.project.devi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/user")
	public String user(Model model) {
		
		return "user/user-list";
	}
}
