package com.app.eyemanage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.app.eyemanage.pojo.PatientDetailsPOJO;
import com.app.eyemanage.service.PatientService;
import com.app.eyemanage.utility.Utils;

@Controller
@RequestMapping("/dashboard")
public class PatientController {
	
	@Autowired
	PatientDetailsPOJO patientDetails;
	
	@Autowired
	PatientService patientService;
	
	private static final Logger logger = Logger.getLogger(PatientController.class);
	
	@RequestMapping(value="/patient" , method=RequestMethod.GET)
	public String patient(Model model, HttpSession session) {
		logger.info("Patient Home Get");
		if( Utils.validateSession(session, "UserDetails") == false) {
			logger.info("Session Attribute is Null");
			logger.info("You are not logged in. Redirecting to Login Page");
			return "redirect:/";
		}
		else {
			return "patient";
		}
	}
	
	@RequestMapping(value="/patientCreate" , method=RequestMethod.GET)
	public String showPatient(Model model, HttpSession session) {
		logger.info("Patient Add Get");
		if( Utils.validateSession(session, "UserDetails") == false) {
			logger.info("Session Attribute is Null");
			logger.info("You are not logged in. Redirecting to Login Page");
			return "redirect:/";
		}
		else {
			model.addAttribute("newPatient",patientDetails);
			return "patientAdd";
		}
	}
	
	@RequestMapping(value="/patientCreate",method=RequestMethod.POST)
	public String createPatient(@ModelAttribute("newPatient")PatientDetailsPOJO patient,ModelMap modelMap) {
		logger.info("Patient Add Post");
		try {
			logger.info("Patient Add Try Block");
			patient.setFirstVisitDate(new Date());
			if(patientService.add(patient) == true){
				logger.info("Patient Successfully Added");
				return "redirect:/dashboard/patient";
			}
			logger.info("Failed to Add.");
			return "redirect:/dashboard/patientCreate";
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Patient Add Catch Block");
			return "redirect:/dashboard/patientCreate";
		}
		
	}
	
	
	@RequestMapping(value="/patientSearch" , method=RequestMethod.GET)
	public String viewPatient(Model model, HttpSession session) {
		logger.info("Patient View Get");
		if( Utils.validateSession(session, "UserDetails") == false) {
			logger.info("Session Attribute is Null");
			logger.info("You are not logged in. Redirecting to Login Page");
			return "redirect:/";
		}
		else {
			model.addAttribute("viewPatient",patientDetails);
			return "patientSearch";
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/patientSearch",method=RequestMethod.POST)
	public String viewPatient(@ModelAttribute("viewPatient")PatientDetailsPOJO patient,ModelMap modelMap) {
		logger.info("Patient View Post");
		List<PatientDetailsPOJO> patientDetails	=	new ArrayList<>();
		try {
			logger.info("Try Block");
			PatientDetailsPOJO patientResult;
			if (patient.getSearchFilter().equalsIgnoreCase("id")) {
				logger.info("Searching By Id");
				patientResult	=	patientService.findOne(Integer.parseInt(patient.getSearchText()));
				logger.info("Searching By Id Successful");
				patientDetails.add(patientResult);
			}
			else if (patient.getSearchFilter().equalsIgnoreCase("name")) {
				logger.info("Searching By Name");
				patientDetails	=	patientService.findPatientByName(patient.getSearchText().toLowerCase());
				logger.info(patientDetails.toString());
				logger.info("Searching By Name Successful");
			}
			else{	// for age
				logger.info("Searching By Age");
				patientDetails	=	patientService.findPatientByAge(Integer.parseInt(patient.getSearchText()));
				logger.info("Searching By Age Successful");
			}
		} catch (NullPointerException e) {
			logger.info("Catch Block");
			logger.info("Searching All");
			patientDetails		=	patientService.findAllPatients();
			logger.info("Searching Successfull");
		} finally {
			logger.info("Finally Block");
			if( patientDetails.size() <= 1 && patientDetails.get(0).equals(null) ){
				logger.info("Nothing found");
			}
			else
			modelMap.addAttribute("patientDetails",patientDetails);
			return "patientSearch";
		}
	}
}