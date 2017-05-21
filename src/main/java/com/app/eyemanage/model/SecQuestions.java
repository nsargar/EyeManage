package com.app.eyemanage.model;

public class SecQuestions {

	private Integer id;
	private String question;
	
	public SecQuestions() {
		// TODO Auto-generated constructor stub
	}
	
	public SecQuestions(Integer id, String question) {
		super();
		this.id = id;
		this.question = question;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "SecQuestions [id=" + id + ", question=" + question + "]";
	}
	
}
