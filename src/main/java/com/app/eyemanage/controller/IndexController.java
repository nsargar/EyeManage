package com.app.eyemanage.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.app.eyemanage.dao.UserDAO;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;
import com.app.eyemanage.serviceimpl.UserServiceImpl;

@Controller
//@RequestMapping("/main")
public class IndexController {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	@Autowired
	UserServiceImpl userService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("Login Get");
		UserPOJO pojo=new UserPOJO();
		model.addAttribute("user",pojo);
		return "login";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String loginForm(@ModelAttribute("user")UserPOJO user, ModelMap modelMap) {
		logger.info("Login Post");
		logger.info(user.getUserId());
		logger.info(user.getPassword());
		return "login";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String showRegister(Model model) {
		logger.info("Register Get");
		UserPOJO pojo	=	new UserPOJO();
		model.addAttribute("newUser", pojo);
		return "registration";
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String register(@ModelAttribute("newUser")UserPOJO user,ModelMap modelMap) {
		logger.info("Register Post");
		logger.info(user.getName());
		logger.info(user.getUserId());
		logger.info(user.getEmail());
		logger.info(user.getPassword());
		//user.setUserId(100);
		userService.add(user);
		return "registration";
	}
	
}