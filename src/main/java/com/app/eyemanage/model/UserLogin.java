package com.app.eyemanage.model;

import org.apache.log4j.Logger;

import com.app.eyemanage.controller.IndexController;

public class UserLogin {
	private Integer userId;
	private String password;
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	public UserLogin() {
		logger.info("Def Ctor user Login");
	}
	
	public UserLogin(Integer userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", password=" + password + "]";
	}
}