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
		if( null == session.getAttribute("UserDetails")) {
			logger.info("Session Attribute is Null");
			return "redirect:/login";
		}
		else {
			session.getAttribute("UserDetails");
			model.addAttribute("userName", session.getAttribute("UserDetails").toString());
			logger.info((session.getAttribute("UserDetails")).toString());
			return "dashboard";
		}
	}
	
	@RequestMapping(value="/home" , method=RequestMethod.POST)
	public String dashboard(Model model, HttpSession session) {
		logger.info("Dashboard Post");
		try {
			session.invalidate();
			logger.info("Successfully Logged out");
			return "redirect:/login";
		} catch (Exception e) {
			logger.info("Unable to Log out");
			e.printStackTrace();
			return "dashboard";
		}
	}
}
