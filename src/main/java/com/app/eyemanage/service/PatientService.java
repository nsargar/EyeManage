package com.app.eyemanage.service;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.eyemanage.pojo.PatientDetailsPOJO;

@Repository
public interface PatientService extends CrudRepository<PatientDetailsPOJO, Integer>{
	
	boolean add(PatientDetailsPOJO patientDetails);
	
	@Query(value="from PatientDetailsPOJO p where (lower(p.firstName)=:name) or (lower(p.lastName)=:name)")
	//@Query(value="from PatientDetailsPOJO p where LOWER(p.firstName)=LOWER(:name)")
	List<PatientDetailsPOJO> findPatientByName(@Param("name") String name);
	
	@Query(value="from PatientDetailsPOJO p where p.age=?1")
	List<PatientDetailsPOJO> findPatientByAge(Integer age);
	
	@Query(value="from PatientDetailsPOJO p")
	List<PatientDetailsPOJO> findAllPatients();
	
}
