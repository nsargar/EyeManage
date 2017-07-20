package com.app.eyemanage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.app.eyemanage.model.Response;
import com.app.eyemanage.pojo.DrugDetailsPOJO;
import com.app.eyemanage.pojo.PatientDetailsPOJO;
import com.app.eyemanage.pojo.VisitDetailsPOJO;
import com.app.eyemanage.service.PatientService;
import com.app.eyemanage.service.VisitService;
import com.app.eyemanage.utility.Utils;

@RestController
@RequestMapping("/dashboard")
public class VisitController {

	private static final Logger logger = Logger.getLogger(VisitController.class);

	@Autowired
	VisitDetailsPOJO visit;
	
	@Autowired
	VisitService visitService;
	
	@Autowired
	PatientDetailsPOJO patient;
	
	@Autowired
	PatientService patientService;

	@RequestMapping(value="/visit" , method=RequestMethod.GET)
	public ModelAndView patient(Model model, HttpSession session) {
		logger.info("Visit Home Get");
		if( Utils.validateSession(session, "UserDetails") == false) {
			logger.info("Session Attribute is Null");
			logger.info("You are not logged in. Redirecting to Login Page");
			//return "redirect:/";
			return new ModelAndView("redirect:/");
		}
		else {
			//return "visit";
			return new ModelAndView("visit");
		}
	}

	@RequestMapping(value="/newVisit/{id}",method=RequestMethod.GET)
	public ModelAndView showVisit( @PathVariable("id") String id , Model model, HttpSession session ) {
		logger.info("New Visit Get");
		logger.info("Patient Id : " + id);
		if( Utils.validateSession(session, "UserDetails") == false) {
			logger.info("Session Attribute is Null");
			logger.info("You are not logged in. Redirecting to Login Page");
			return new ModelAndView("redirect:/");
		}
		else {
			List<DrugDetailsPOJO> drugsList	=	new ArrayList<>();
			patient	=	patientService.findOne(Integer.parseInt(id));
			model.addAttribute("patient", patient);
			model.addAttribute("newVisit",visit);
			model.addAttribute("drugsList", drugsList);
			return new ModelAndView("visitAdd");
		}
	}

	/*public ModelAndView addVisit( @ModelAttribute("newVisit") VisitDetailsPOJO visit,
	@ModelAttribute("drugsList") ArrayList<DrugDetailsPOJO> drugs, 
	@PathVariable("id")String id, ModelMap modelMap ) {*/
	
	@RequestMapping(value = "/newVisit/{id}", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public Response addVisit( @PathVariable("id")String id, @RequestBody VisitDetailsPOJO v){	
		logger.info("New Visit Post");
		
		try {
			logger.info("New Visit Try");
			patient	=	patientService.findOne(Integer.parseInt(id));
			v.setVisitDate(new Date());
			v.setPatient(patient);
			if( null != patient ) {
				logger.info("Visit Details : " + v.toString());
				visit	=	visitService.addVisit(v);
				if( null != visit ) {
					logger.info("Visit Successfully Created");
					return new Response("Done","s");
				}
				logger.info("Visit could not be added");
				return new Response("Error","f");
			}
			return new Response("Error","f");
		} catch (Exception e) {
			logger.info("New Visit Catch : " + e);
			return new Response("Error","f");
		}
		
	}
}
