package com.app.eyemanage.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.eyemanage.model.UserLogin;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/home" , method=RequestMethod.GET)
	public String showdashboard(Model model, HttpSession session) {
		logger.info("Dashboard Get");
		session.getAttribute("UserDetails");
		logger.info(((UserLogin)session.getAttribute("UserDetails")).toString());
		
		// Needs validation for direct access of "dashboard" view without logging in. 
		return "dashboard";
	}
	
	@RequestMapping(value="/home" , method=RequestMethod.POST)
	public String dashboard(Model model, HttpSession session) {
		logger.info("Dashboard Post");
		try {
			session.invalidate();
			logger.info("Successfully Logged out");
		} catch (Exception e) {
			logger.info("Unable to Log out");
			e.printStackTrace();
		}
		return "redirect:/login";
	}
}
