package com.project.devi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.devi.model.User;
import com.project.devi.service.UserService;

@Controller
public class UserApiController {

	private final UserService userService;
	
	@Autowired
	public UserApiController(UserService userService) {
		this.userService = userService;
	}
}
