package com.app.eyemanage.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.app.eyemanage.model.ForgotPassword;
import com.app.eyemanage.model.SecQuestions;
import com.app.eyemanage.model.UserLogin;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;
import com.app.eyemanage.serviceimpl.UserServiceImpl;

@Controller
//@RequestMapping("/main")
public class UserController  {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired 
	UserService userService;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	*/
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("Login Get");
		UserLogin loginReq=new UserLogin();
		model.addAttribute("user",loginReq);
		return "login";
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String loginForm(@ModelAttribute("user")UserLogin user, ModelMap modelMap, HttpSession session) {
		logger.info("Login Post");
		logger.info(user.getUserId());
		logger.info(user.getPassword());
		int a	=	 userService.validateLogin(user.getUserId(),user.getPassword());
		if (a == 0) {
			logger.info("Login Failed");
			return "redirect:/login";
		}
		else {
			logger.info("Successfully Logged in");
			session.setAttribute("UserDetails", user );
			//logger.info(session.getAttribute("UserDetails").toString());
			return "redirect:/dashboard/home";
		}
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String showRegister(Model model) {
		logger.info("Register Get");
		UserPOJO pojo	=	new UserPOJO();
		model.addAttribute("newUser", pojo);
		HashMap<Integer, String> question	=	new HashMap<>();
		/*SecQuestions question	=	new SecQuestions();*/
		model.addAttribute("question",question);
		HashMap<Integer, String> questions	=	new HashMap<>();
		//questions.putAll(userService.findAllQues());
		questions.put(1, "What is your nick name?");
		logger.info("Questions Map"+questions.toString());
		model.addAttribute("questions", questions);
		return "registration";
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String register(@ModelAttribute("newUser")UserPOJO user,ModelMap modelMap) {
		logger.info("Register Post");
		if(userService.add(user) == true){
			logger.info("Registration Successful, Redirecting to Login page");
			return "redirect:/login";
		}
		logger.info("Registration failed");
		return "registration";
	}
	
	@RequestMapping(value="/forgotPassword" , method=RequestMethod.GET)
	public String showForgotPassword(Model model) {
		logger.info("ForgotPassword Get");
		ForgotPassword pojo	=	new ForgotPassword();
		model.addAttribute("forgotUser", pojo);
		return "forgotPassword";
	}
	
	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST)
	public String forgotPassword(@ModelAttribute("forgotUser")ForgotPassword user,ModelMap modelMap) {
		logger.info("Forgot Password Post");
		if(userService.forgotPassCheck(user))
			return "redirect:/login";
		else
			return "forgotPassword";
	}
	
}