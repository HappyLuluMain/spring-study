package com.project.devi.model;

import java.time.LocalDateTime;

public class Board {
	
	private Long id;
	private String title;
	private String content;
	private Integer userId;
	private Integer count;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public Board() {}
	
	// BoardSaveRequestDto -> Board를 위한 constructor
	public Board(String title, String content, Integer userId) {
		this.title = title;
		this.content = content;
		this.userId = userId;
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
	public Integer getCount() {
		return count;
	}
	public Integer getUserId() {
		return userId;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	
	
	
}
