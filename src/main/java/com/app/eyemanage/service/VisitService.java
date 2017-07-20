package com.app.eyemanage.service;

import org.springframework.data.repository.CrudRepository;
import com.app.eyemanage.pojo.VisitDetailsPOJO;

public interface VisitService extends CrudRepository<VisitDetailsPOJO, Integer>{
	
	VisitDetailsPOJO addVisit(VisitDetailsPOJO visitDetails);
}
