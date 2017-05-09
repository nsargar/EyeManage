package com.app.eyemanage.serviceimpl;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.*;

import com.app.eyemanage.controller.IndexController;
import com.app.eyemanage.dao.UserDAO;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;
@ComponentScan
@Service
@Transactional
@DependsOn("")
public class UserServiceImpl {

	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	//private final UserService user; 
	private UserService user;
	public UserServiceImpl(UserService user) {
	
		this.user = user;
	}

	public void add() {
		logger.info("User Service Impl , User ::: " );
		this.user.save(new UserPOJO("Nilis08", "nilis", "voidprongzz", "ggfjyskjf.asdg@dhf.com"));
	}	
}