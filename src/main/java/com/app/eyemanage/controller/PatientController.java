package com.app.eyemanage.controller;

import java.util.ArrayList;
import java.util.Date;
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
			return "redirect:/login";
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
			return "redirect:/login";
		}
		else {
			model.addAttribute("newPatient",patientDetails);
			return "patientAdd";
		}
	}
	
	@RequestMapping(value="/patientCreate",method=RequestMethod.POST)
	public String createPatient(@ModelAttribute("newPatient")PatientDetailsPOJO patient,ModelMap modelMap) {
		logger.info("Patient Add Post");
		patient.setPatientId("P01");
		patient.setFirstVisitDate(new Date());
		if(patientService.add(patient) == true){
			logger.info("Patient Successfully Added");
			return "redirect:/dashboard/patient";
		}
		logger.info("Failed to Add.");
		return "redirect:/dashboard/patientCreate";
	}
	
	
	@RequestMapping(value="/patientSearch" , method=RequestMethod.GET)
	public String viewPatient(Model model, HttpSession session) {
		logger.info("Patient View Get");
		if( Utils.validateSession(session, "UserDetails") == false) {
			logger.info("Session Attribute is Null");
			logger.info("You are not logged in. Redirecting to Login Page");
			return "redirect:/login";
		}
		else {
			model.addAttribute("viewPatient",patientDetails);
			return "patientSearch";
		}
	}
	
	@RequestMapping(value="/patientSearch",method=RequestMethod.POST)
	public String viewPatient(@ModelAttribute("viewPatient")PatientDetailsPOJO patient,ModelMap modelMap) {
		logger.info("Patient View Post");
		PatientDetailsPOJO patientResult				=	patientService.findOne(patient.getPatientId());
		ArrayList<PatientDetailsPOJO> patientDetails	=	new ArrayList<>();
		//List<PatientDetailsPOJO> patientDetails		=	patientService.findAllPatients();
		patientDetails.add(patientResult);
		if( !patientDetails.isEmpty()){
			logger.info("Viewed Successfully");
			logger.info(patientDetails.toString());
			modelMap.addAttribute("patientDetails",patientDetails);
			return "patientSearch";
		}
		else {
			logger.info("Failed to View.");
			return "redirect:/dashboard/patientSearch";
		}
	}
	/*
	@RequestMapping(value="/patientDelete",method=RequestMethod.POST)
	public String deletePatient(@RequestBody PatientDetailsPOJO patient ) {
		logger.info("Patient Delete Post");
		try {
			patientService.delete(patient.getPatientId());
			return "success";
		} catch (Exception e) {
			logger.info("Could Not Delete : ", e);
			return "failure";
		}
	}
	*/
}