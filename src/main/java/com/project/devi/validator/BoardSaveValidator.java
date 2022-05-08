package com.project.devi.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.devi.dto.BoardSaveRequestDto;

@Component
public class BoardSaveValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return BoardSaveRequestDto.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		BoardSaveRequestDto requestDto = (BoardSaveRequestDto) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content.empty");
	}
}
