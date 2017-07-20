package com.app.eyemanage.serviceimpl;

import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.eyemanage.pojo.DrugDetailsPOJO;
import com.app.eyemanage.pojo.VisitDetailsPOJO;
import com.app.eyemanage.service.VisitService;

public class VisitServiceImpl {
	private static final Logger logger = Logger.getLogger(VisitServiceImpl.class);
	
	@Autowired
	VisitService visitService;
	
	@Transactional
	VisitDetailsPOJO addVisit(VisitDetailsPOJO visitDetails) {
		logger.info("VisitServiceImpl , Visit ::: " + visitDetails.toString() );
		
		VisitDetailsPOJO visitAdd	=	visitService.save(visitDetails);
		logger.info("Returned Object::: " + visitAdd.toString());
		if( !visitAdd.getVisitId().equals(null)){
			return visitAdd;
		}
		else {
			logger.info("Visit could not be created !!!");
			return null;
		}
	}
}
