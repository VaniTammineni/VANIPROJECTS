package com.faqs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIXFAQS")
public class Unix {
	@Id
	@Column(name="uqustnID", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uqustnId;
	
	@Column(name="uquestion")
	private String uQuestion;
	
	@Column(name="uanswer")
	private byte[] uAnswer;
	public int getUqustnId() {
		return uqustnId;
	}
	public void setUqustnId(int uqustnId) {
		this.uqustnId = uqustnId;
	}
	public String getuQuestion() {
		return uQuestion;
	}
	public void setuQuestion(String uQuestion) {
		this.uQuestion = uQuestion;
	}
	public byte[] getuAnswer() {
		return uAnswer;
	}
	public void setuAnswer(byte[] uAnswer) {
		this.uAnswer = uAnswer;
	}
	

}
