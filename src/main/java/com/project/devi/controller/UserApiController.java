package com.project.devi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.devi.model.User;

@Controller
@RequestMapping("/api/v1")
public class UserApiController {

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public void save(User user) {
		
	}
}
