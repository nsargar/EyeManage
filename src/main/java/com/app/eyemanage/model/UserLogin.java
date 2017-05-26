package com.app.eyemanage.model;

import org.apache.log4j.Logger;

import com.app.eyemanage.controller.UserController;

public class UserLogin {
	private String userName;
	private String password;
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	public UserLogin() {
		logger.info("Default Constructor User Login");
	}
	
	public UserLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [userName=" + userName + ", password=" + password + "]";
	}
}
