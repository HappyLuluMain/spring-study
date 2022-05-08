package com.project.devi.model;

public class Attachments {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private Long bno;
	
	public Attachments() {}
	
	public Attachments(String uuid, String uploadPath, String fileName, Long bno) {
		this.uuid = uuid;
		this.uploadPath = uploadPath;
		this.fileName = fileName;
		this.bno = bno;
	}
	
	public String getUuid() {
		return uuid;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public Long getBno() {
		return bno;
	}
}
