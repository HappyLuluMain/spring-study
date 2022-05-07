package com.project.devi.dto;

import javax.validation.constraints.NotBlank;

import com.project.devi.model.Board;

public class BoardSaveRequestDto {
	
	@NotBlank(message = "제목은 필수 입력 값입니다")
	private String title;
	
	@NotBlank(message = "내용은 필수 입력 값입니다")
	private String content;
	
	private Integer userId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Board toEntity() {
		return new Board(title, content, userId);
	}
}
