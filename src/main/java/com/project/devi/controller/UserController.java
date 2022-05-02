package com.project.devi.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.devi.dto.UserRequestDto;
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
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String save(Model model, @Valid UserRequestDto userRequestDto, Errors errors) {
		System.out.println(errors.hasErrors());
		System.out.println(userRequestDto.getUsername());
		if(errors.hasErrors()) {
			model.addAttribute("userDto", userRequestDto);
			Map<String, String> validResult = userService.validateHandling(errors);
			for(String key : validResult.keySet()) {
				model.addAttribute(key, validResult.get(key));
			}
			return "user/user-save";
		}
		userService.save(userRequestDto);
		return "redirect:/";
	}
}
