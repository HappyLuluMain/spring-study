package com.project.devi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.devi.dao.UserDao;
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
	
	
	
	public Integer save(User user) {
		
		user.setRole(UserRole.USER);
		
		return userDao.save(user);
	}
}
