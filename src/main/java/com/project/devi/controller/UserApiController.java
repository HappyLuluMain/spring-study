package com.project.devi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.devi.dto.UserRequestDto;
import com.project.devi.service.UserService;

@RestController
public class UserApiController {

	private final UserService userService;
	
	@Autowired
	public UserApiController(UserService userService) {
		this.userService = userService;
	}
	
	//회원가입과 유효성 검사
	@RequestMapping(value = "/api/v1/user", method = RequestMethod.POST)
	public ResponseEntity<UserRequestDto> save(Model model, @Valid @RequestBody UserRequestDto userRequestDto) {
		
		//유효성 검사 통과 실패시 ExceptionController에서 MethodArgumentNotValidException 처리
		
		userService.save(userRequestDto);
		
		return new ResponseEntity<>(userRequestDto, HttpStatus.OK);
	}
}
