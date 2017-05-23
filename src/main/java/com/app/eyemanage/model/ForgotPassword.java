package com.app.eyemanage.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ForgotPassword {
	private Integer userId;
	private String secQuest;
	private String answer;
	private String newPassword;
	private String confirmPassword;
	
	
	public ForgotPassword() {
		// TODO Auto-generated constructor stub
	}
	
	public ForgotPassword(Integer userId, String secQuest, String answer) {
		super();
		this.userId = userId;
		this.secQuest = secQuest;
		this.answer = answer;
	}
	
	
	@NotNull
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@NotNull
	@Column(length=100)
	public String getSecQuest() {
		return secQuest;
	}
	public void setSecQuest(String secQuest) {
		this.secQuest = secQuest;
	}
	
	@NotNull
	@Column(length=30)
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@NotNull
	@Column(length=16)
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@NotNull
	@Column(length=16)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ForgotPassword [userId=" + userId + ", secQuest=" + secQuest + ", answer=" + answer + ", newPassword="
				+ newPassword + ", confirmPassword=" + confirmPassword + "]";
	}
	
}
