package com.app.eyemanage.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Entity
@Table(name="PatientDetails")
@Component
public class PatientDetailsPOJO {
	
	@Column(unique = true, nullable = false)
	@Id
	@SequenceGenerator(name="Patient_SEQ", sequenceName="Patient_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Patient_SEQ")
	private Integer patientId;
	
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
	
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = false, nullable = false)
	private Date birthDate;
	
	@Column(unique = false, nullable = false, length=1)
	private String gender;
	
	@Column(unique = false, nullable = true, length=10)
	private Long mobile;
	
	@Column(unique = false, nullable = true, length=15)
	private Long phoneNumber;
	
	@Column(unique = false, nullable = false)
	@CreatedDate
	private Date firstVisitDate;
	
	@Transient
	private String searchFilter;
	
	@Transient
	private String searchText;
	
	private static final Logger logger = Logger.getLogger(PatientDetailsPOJO.class);
	
	public PatientDetailsPOJO() {
		logger.info("Default Constructor PatientDetails");
	}
	
}
