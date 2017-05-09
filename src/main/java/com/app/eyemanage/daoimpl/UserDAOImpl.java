package com.app.eyemanage.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.eyemanage.controller.IndexController;
import com.app.eyemanage.dao.UserDAO;
import com.app.eyemanage.pojo.UserPOJO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
/*	@Autowired
	 private SessionFactory sf;*/

	@Override
	public void addUser(UserPOJO user) {
		logger.info("UserDAOImpl.... User...");
		//sf.getCurrentSession().persist(user);
	}
	
	
}
