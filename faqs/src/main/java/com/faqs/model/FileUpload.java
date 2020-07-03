package com.faqs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="fileupload")
public class FileUpload {
	@Id
	@Column(name="fid", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fid;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="pfile")
	private byte[] pfile;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "filePath")
	private String filePath;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getFile() {
		return pfile;
	}

	public void setFile(byte[] file) {
		this.pfile = file;
	}
}
