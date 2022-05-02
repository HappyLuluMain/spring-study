package com.project.devi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.project.devi.model.User;
import com.project.devi.model.UserRole;

public class UserRequestDto {
	
	@NotBlank(message = "아이디는 필수 입력 값입니다")
	private String username;
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요")
	private String password;
	
	@Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다")
	private String email;
	
	public UserRequestDto() {}
	
	public UserRequestDto(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User toEntity() {
		return new User(username, password, email, UserRole.USER);
	}
	
}
