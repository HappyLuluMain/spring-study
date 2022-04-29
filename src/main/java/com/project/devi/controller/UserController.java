package com.project.devi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	// 유저 가입 페이지
	@RequestMapping("/user")
	public String userSave() {
		
		return "user/user-save";
	}
}
