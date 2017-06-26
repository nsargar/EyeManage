package com.app.eyemanage.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import com.app.eyemanage.model.ForgotPassword;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;
import com.app.eyemanage.utility.Utils;

@ComponentScan
@Service
@Transactional
public class UserServiceImpl {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	UserPOJO userPojo;
	
	public UserServiceImpl(UserService userService) {
		this.userService = userService;
	}

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public boolean add(UserPOJO userDetails) {
		logger.info("User Service Impl , User ::: " + userDetails.toString());
		if(userService.validateUserName(userDetails.getUserName()) <= 0) {
			if(Utils.validatePass(userDetails.getPassword(), userDetails.getCnfPassword())) {
				UserPOJO demoUser	=	this.userService.save(userDetails);
				logger.info("Returned Object::: " + demoUser.toString());
					if( !demoUser.getUserName().equalsIgnoreCase(null)){
						return true;
					}
					else {
						logger.info("User could not be created !!!");
						userPojo.setRegistrationError("Error in Adding");
						return false;
					}
			}
			else {
				logger.info("Passwords do not match !!!");
				userPojo.setRegistrationError("Passwords do not match");
				return false;
			}
		}
		else {
			logger.info("UserName already exists !!!");
			userPojo.setRegistrationError("User Name already exists, please try another");
			return false;
		}
	}
	
	/*
	@Transactional
	public Map<String, Boolean> add(UserPOJO userDetails) {
		Map<String, Boolean> resultMap	=	new HashMap<>();
		logger.info("User Service Impl , User ::: " + userDetails.toString());
		if(userService.validateUserName(userDetails.getUserName()) <= 0) {
			if(Utils.validatePass(userDetails.getPassword(), userDetails.getCnfPassword())) {
				UserPOJO demoUser	=	this.userService.save(userDetails);
				logger.info("Returned Object::: " + demoUser.toString());
					if( !demoUser.getUserName().equalsIgnoreCase(null)){
						resultMap.put( null , true );
						return resultMap;
					}
					else {
						logger.info("User could not be created !!!");
						userPojo.setRegistrationError("Error in Adding");
						resultMap.put( "Error in Adding" , false );
						return resultMap;
					}
			}
			else {
				logger.info("Passwords do not match !!!");
				userPojo.setRegistrationError("Passwords do not match");
				resultMap.put( "Passwords do not match" , false );
				return resultMap;
			}
		}
		else {
			logger.info("UserName already exists !!!");
			userPojo.setRegistrationError("User Name already exists, please try another");
			resultMap.put( "User Name already exists, please try another" , false );
			return resultMap;
		}
	}
	
	*/
	@Transactional
	public boolean forgotPassCheck(ForgotPassword forgotUser) {
		logger.info("forgotPassCheck method");
		try {
			if(Utils.validatePass(forgotUser.getNewPassword(),forgotUser.getConfirmPassword()) && 
					 (userService.updatePassword(forgotUser.getNewPassword(), forgotUser.getUserName()) > 0) ) {
				return true;
			}
			return false;
		}
		catch (Exception e) {
			return false;
		}
			
	}
}
