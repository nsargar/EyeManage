package com.app.eyemanage.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import com.app.eyemanage.controller.UserController;
import com.app.eyemanage.model.UserLogin;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;

@ComponentScan
@Service
@Transactional
public class UserServiceImpl{
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	public UserServiceImpl(UserService userService) {
		this.userService = userService;
	}

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public boolean add(UserPOJO userDetails) {
		logger.info("User Service Impl , User ::: " + userDetails.toString());
		UserPOJO demoUser	=	this.userService.save(userDetails);
		logger.info("Returned Object::: " + demoUser.toString());
		if( demoUser.getUserId() != 0){
			return true;
		}
		else
			return false;
		
	}
	
	public Integer validateLogin(UserLogin userLogin) {
		logger.info("In ValidateLogin method");	
		int result	=	this.userService.validateLogin(userLogin.getUserId(), userLogin.getPassword());
		return result;
	}
	
}