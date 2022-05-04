package com.project.devi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	// 기본 index 페이지
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
}
