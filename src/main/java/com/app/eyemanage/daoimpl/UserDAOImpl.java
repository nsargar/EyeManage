package com.app.eyemanage.daoimpl;

import org.apache.log4j.Logger;
import com.app.eyemanage.controller.UserController;
import com.app.eyemanage.dao.UserDAO;
import com.app.eyemanage.pojo.UserPOJO;

//@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
/*	@Autowired
	 private SessionFactory sf;*/

	@Override
	public void addUser(UserPOJO user) {
		logger.info("UserDAOImpl.... User...");
		//sf.getCurrentSession().persist(user);
	}
	
	
}
