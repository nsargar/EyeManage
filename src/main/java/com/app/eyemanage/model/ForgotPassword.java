package com.app.eyemanage.model;

public class ForgotPassword {
	private Integer userId;
	private String secQuest;
	private String answer;
	
	
	public ForgotPassword() {
		// TODO Auto-generated constructor stub
	}
	
	public ForgotPassword(Integer userId, String secQuest, String answer) {
		super();
		this.userId = userId;
		this.secQuest = secQuest;
		this.answer = answer;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getSecQuest() {
		return secQuest;
	}
	public void setSecQuest(String secQuest) {
		this.secQuest = secQuest;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "ForgotPassword [userId=" + userId + ", secQuest=" + secQuest + ", answer=" + answer + "]";
	}
	
	
}
