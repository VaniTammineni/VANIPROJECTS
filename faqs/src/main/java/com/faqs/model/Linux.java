package com.faqs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="LINUXFAQS")
public class Linux {
	@Id
	@Column(name="lqustnID", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lqustnId;
	
	@Column(name="lquestion")
	private String lQuestion;
	
	@Column(name="lanswer")
	private byte[]  lAnswer;
	
	public int getLqustnId() {
		return lqustnId;
	}
	public void setLqustnId(int lqustnId) {
		this.lqustnId = lqustnId;
	}
	public String getlQuestion() {
		return lQuestion;
	}
	public void setlQuestion(String lQuestion) {
		this.lQuestion = lQuestion;
	}
	public byte[] getlAnswer() {
		return lAnswer;
	}
	public void setlAnswer(byte[] lAnswer) {
		this.lAnswer = lAnswer;
	}
	

}
