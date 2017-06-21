package com.app.eyemanage.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.eyemanage.pojo.PatientDetailsPOJO;

@Repository
public interface PatientService extends CrudRepository<PatientDetailsPOJO, String>{
	
	boolean add(PatientDetailsPOJO patientDetails);
	
	@Query(value="from PatientDetailsPOJO p")
	List<PatientDetailsPOJO> findAllPatients();
	
	
	
}
