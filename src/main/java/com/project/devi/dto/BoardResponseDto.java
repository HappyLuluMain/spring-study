package com.project.devi.dto;

import java.time.LocalDateTime;

import com.project.devi.model.Board;

public class BoardResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private Integer userId;
	private Integer count;
	private String username;
	private LocalDateTime modifiedDate;
	
	public BoardResponseDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.userId = board.getUserId();
		this.count = board.getCount();
		this.modifiedDate = board.getModifiedDate();
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getCount() {
		return count;
	}

	public String getUsername() {
		return username;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	
}