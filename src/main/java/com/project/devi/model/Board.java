package com.project.devi.model;

import java.time.LocalDateTime;

public class Board {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	private Integer count;
	private Integer userId;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public Board() {}
	
	public Board(Long id, String title, String content, String author, Integer count, Integer userId,
			LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.count = count;
		this.userId = userId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
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
	public String getAuthor() {
		return author;
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
