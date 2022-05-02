package com.project.devi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.devi.service.UserService;

@Controller
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 유저 가입 페이지
	@RequestMapping("/user")
	public String userSave() {
		
		return "user/user-save";
	}
}
