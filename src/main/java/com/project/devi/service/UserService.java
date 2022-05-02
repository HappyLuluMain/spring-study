package com.project.devi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.project.devi.dao.UserDao;
import com.project.devi.dto.UserRequestDto;
import com.project.devi.model.User;
import com.project.devi.model.UserRole;

@Service
public class UserService {
	
	private final UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public User findByUsernameAndPassword(String username, String password) {
		
		return userDao.findByUsernameAndPassword(username, password);
	}
	
	
	
	public void save(UserRequestDto userRequestDto) {
		User user = userRequestDto.toEntity();
		userDao.save(user);
	}
	
	// 유효성 검사 핸들링
	public Map<String, String> validateHandling(Errors errors){
		Map<String, String> result = new HashMap<String, String>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String key = String.format("valid_%s", error.getField());
			result.put(key, error.getDefaultMessage());
		}
		return result;
	}
}
