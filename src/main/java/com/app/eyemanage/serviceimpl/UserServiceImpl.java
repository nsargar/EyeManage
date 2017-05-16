package com.app.eyemanage.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import com.app.eyemanage.controller.IndexController;
import com.app.eyemanage.model.UserLogin;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;

@ComponentScan
@Service
@Transactional
public class UserServiceImpl {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	private UserService user;
	
	public UserServiceImpl(UserService user) {
		this.user = user;
	}

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public void add(UserPOJO userDetails) {
		logger.info("User Service Impl , User ::: " + userDetails.toString());
		UserPOJO demoUser	=	this.user.save(userDetails);
		logger.info("Returned Object::: " + demoUser.toString());
		logger.info("2 User Service Impl , User ::: " + userDetails.toString());
	}
	
	
	public boolean validateLogin(UserLogin userLogin) {
		logger.info("In ValidateLogin method");		
		return this.user.exists(userLogin.getUserId());
	}
	
	
}