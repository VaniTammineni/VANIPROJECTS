package com.faqs.model;
import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JAVAQUSTNS")
public class Editor {
	@Id
	@Column(name="qustnID", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int qustnId;
	
	public int getQustnId() {
		return qustnId;
	}
	public void setQustnId(int qustnId) {
		this.qustnId = qustnId;
	}
		@Column(name="Question")
	private String question ;
	
	
	@Column(name="Answer")
	private byte[] editor;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	public byte[] getEditor() {
		return this.editor;
	}
	public void setEditor(byte[] editor) {
		this.editor = editor;
	}

}
