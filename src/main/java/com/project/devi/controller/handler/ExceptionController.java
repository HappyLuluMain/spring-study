package com.project.devi.controller.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionController {

	// 400에러 발생시 에러 내용을 담은 객체를 리턴해주는 핸들러
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach(error -> errors.put(((FieldError) error).getField(), error.getDefaultMessage()));
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
