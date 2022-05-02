package com.project.devi.model;

import java.time.LocalDateTime;

public class User {
	
	private Integer id;
	private String password;
	private String email;
	private String username;
	private UserRole role;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public User() {}
	
	public User(String username, String password, String email, UserRole role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public UserRole getRole() {
		return role;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	
	
	
	
}
