package com.project.devi.dto;

import org.springframework.web.multipart.MultipartFile;

import com.project.devi.model.Board;

public class BoardSaveRequestDto {
	
	private String title;
	
	private String content;
	
	private Integer userId;
	
	private MultipartFile file;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Board toEntity() {
		return new Board(title, content, userId);
	}
}
