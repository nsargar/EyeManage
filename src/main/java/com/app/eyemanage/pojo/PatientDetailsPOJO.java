package com.app.eyemanage.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Entity
@Table(name="PatientDetails")
@Component
public class PatientDetailsPOJO {
	
	@Column(unique = true, nullable = false, length=10)
	@Id
	private String patientId;
	
	@Column(unique = false, nullable = false, length=20)
	private String firstName;
	
	@Column(unique = false, nullable = false, length=20)
	private String lastName;
	
	@Column(unique = false, nullable = false, length=2)
	private Integer age;
	
	@Column(unique = false, nullable = false, length=100)
	private String address;
	
	@Column(unique = false, nullable = true, length=50)
	@Email
	private String email;
	
	@Column(unique = false, nullable = false, length=1)
	private String gender;
	
	@Column(unique = true, nullable = false, length=10)
	private Long mobile;
	
	@Column(unique = false, nullable = true, length=15)
	private String phoneNumber;
	
	@Column(unique = false, nullable = false)
	@CreatedDate
	private Date firstVisitDate;
	
	private static final Logger logger = Logger.getLogger(PatientDetailsPOJO.class);
	
	public PatientDetailsPOJO() {
		logger.info("Default Constructor PatientDetails");
	}
	
}
