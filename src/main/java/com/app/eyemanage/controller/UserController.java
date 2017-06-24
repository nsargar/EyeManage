package com.app.eyemanage.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.app.eyemanage.model.ForgotPassword;
import com.app.eyemanage.model.SecQuestions;
import com.app.eyemanage.model.UserLogin;
import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.SecQuestionService;
import com.app.eyemanage.service.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired 
	UserService userService;
	
	@Autowired
	SecQuestionService passwordService;
	
	@SuppressWarnings("finally")
	@RequestMapping(method=RequestMethod.GET , value="/")
	public String index(Model model) {
		logger.info("Index Get");
		UserLogin loginReq=new UserLogin();
		model.addAttribute("user",loginReq);
		
		UserPOJO pojo	=	new UserPOJO();
		model.addAttribute("newUser", pojo);
		
		List<SecQuestions> question		=	new ArrayList<>();
		model.addAttribute("question",question);
		
		try {
			logger.info("Get Questions Try Block");
			List<SecQuestions> questions	=	passwordService.findAllQues();
			logger.info(questions);
			model.addAttribute("questions", questions);
		} catch (NullPointerException e) {
			// TODO: handle exception
			logger.info("Get Questions Catch Block");
		}finally {
			logger.info("Get Questions Finally Block");
			return "index";
		}
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String loginForm(@ModelAttribute("user")UserLogin user, ModelMap modelMap, HttpSession session) {
		logger.info("Login Post");
		try {
			logger.info("Try Block");
			logger.info(user.getUserName());
			logger.info(user.getPassword());
			int a	=	 userService.validateLogin(user.getUserName(),user.getPassword());
			if (a == 0) {
				logger.info("Login Failed");
				return "redirect:/";	// /login to / (due to merging of Login and Register on Index page)
			}
			else {
				logger.info("Successfully Logged in");
				session.setAttribute("UserDetails", user.getUserName() );
				//logger.info(session.getAttribute("UserDetails").toString());
				return "redirect:/dashboard/home";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Catch Block");
			return "redirect:/dashboard/home";
		}
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String register(@ModelAttribute("newUser")UserPOJO user,ModelMap modelMap) {
		logger.info("Register Post");
		try {
			if(userService.add(user) == true){
				logger.info("Registration Successful, Redirecting to Login page");
				//return "redirect:/";		// /login to / (due to merging of Login and Register on Index page)
			}
			else
				logger.info("Registration Failed, Could not add the new user");
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Registration Failed");
		}
		return "redirect:/";			// /registration to / (due to merging of Login and Register on Index page)
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/forgotPassword" , method=RequestMethod.GET)
	public String showForgotPassword(Model model) {
		logger.info("ForgotPassword Get");
		ForgotPassword pojo	=	new ForgotPassword();
		model.addAttribute("forgotUser", pojo);
		
		List<SecQuestions> question		=	new ArrayList<>();
		model.addAttribute("question",question);
		
		try {
			logger.info("Get Questions Try Block");
			List<SecQuestions> questions	=	passwordService.findAllQues();
			logger.info(questions);
			model.addAttribute("questions", questions);
		} catch (NullPointerException e) {
			// TODO: handle exception
			logger.info("Get Questions Catch Block");
		}finally {
			logger.info("Get Questions Finally Block");
			return "forgotPassword";
		}
		
	}
	
	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST)
	public String forgotPassword(@ModelAttribute("forgotUser")ForgotPassword user,ModelMap modelMap) {
		logger.info("Forgot Password Post");
		try {
			logger.info("Forgot Password Try Block");
			if ( userService.quesAnswerCheck(user.getUserName(), user.getSecQuest(), user.getAnswer()) > 0 ) {
				logger.info(" Count : " + userService.quesAnswerCheck(user.getUserName(), user.getSecQuest(), user.getAnswer()));
				if(userService.forgotPassCheck(user)) {
					logger.info("Password Reset Successfully");
					return "redirect:/";		// /login to / (due to merging of Login and Register on Index page)
				}
				else
					return "redirect:/forgotPassword";
			}
			else
				return "redirect:/forgotPassword";
		} catch (Exception e) {
			logger.info("Forgot Password Catch Block");
			return "redirect:/forgotPassword";
		}
	}
}
