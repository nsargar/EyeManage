package com.app.eyemanage.service;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import com.app.eyemanage.pojo.VisitDetailsPOJO;

public interface VisitService extends CrudRepository<VisitDetailsPOJO, Integer>{
	
	VisitDetailsPOJO addVisit(VisitDetailsPOJO visitDetails);
	
	@Query(value="from VisitDetailsPOJO v where (lower(v.patient.firstName) like %:name%) or (lower(v.patient.lastName) like %:name%)")
	List<VisitDetailsPOJO> findVisitByName(@Param("name") String name);
}
