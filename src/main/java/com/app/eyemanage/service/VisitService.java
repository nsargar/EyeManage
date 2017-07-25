package com.app.eyemanage.service;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import com.app.eyemanage.pojo.VisitDetailsPOJO;

public interface VisitService extends CrudRepository<VisitDetailsPOJO, Integer>{
	
	VisitDetailsPOJO addVisit(VisitDetailsPOJO visitDetails);
	
	@Query(value="from VisitDetailsPOJO v where (lower(v.patient.firstName) like %:name%) or (lower(v.patient.lastName) like %:name%)")
	List<VisitDetailsPOJO> findVisitByName(@Param("name") String name);
	
	@Query(value="from VisitDetailsPOJO v where v.visitDate between to_date(:fromDate) and to_date(:toDate) + (86399/86400)")
	List<VisitDetailsPOJO> findVisitByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
