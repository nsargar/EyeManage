package com.app.eyemanage.serviceimpl;

import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.eyemanage.pojo.VisitDetailsPOJO;
import com.app.eyemanage.service.VisitService;

public class VisitServiceImpl {
	private static final Logger logger = Logger.getLogger(VisitServiceImpl.class);
	
	@Autowired
	VisitService visitService;
	
	@Transactional
	VisitDetailsPOJO addVisit(VisitDetailsPOJO visitDetails) {
		logger.info("VisitServiceImpl , Visit ::: " + visitDetails.toString() );
		setDefault(visitDetails);
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
	
	void setDefault(VisitDetailsPOJO visitDetails) {
		logger.info("SetDefault method");
		if ( null == visitDetails.getAxisDistLeft())
			visitDetails.setAxisDistLeft(0);
		if ( null == visitDetails.getAxisDistRight())
			visitDetails.setAxisDistRight(0);
		if ( null == visitDetails.getAxisNearLeft())
			visitDetails.setAxisNearLeft(0);
		if ( null == visitDetails.getAxisNearRight())
			visitDetails.setAxisNearRight(0);
		if ( null == visitDetails.getIop())
			visitDetails.setIop(0);
		if ( null == visitDetails.getKeraK1())
			visitDetails.setKeraK1(0.00F);
		if ( null == visitDetails.getKeraK2())
			visitDetails.setKeraK2(0.00F);
		if ( null == visitDetails.getAxialLength())
			visitDetails.setAxialLength(0.00F);
		if ( null == visitDetails.getIolPower())
			visitDetails.setIolPower(0.00F);
		if ( null == visitDetails.getFollowUp())
			visitDetails.setFollowUp(0);
		if ( null == visitDetails.getFees())
			visitDetails.setFees(0.00F);
	}
}
