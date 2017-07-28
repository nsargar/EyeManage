package com.app.eyemanage.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Entity
//@EntityListeners(VisitServiceImpl.class)
@Table(name="VisitDetails")
@Component
public class VisitDetailsPOJO {
	
	@Id
	@SequenceGenerator(name="Visit_SEQ", sequenceName="Visit_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Visit_SEQ")
	@Column(unique = true, nullable = false)
	private Integer visitId;
	
	@ManyToOne
	@JoinColumn( name = "patientId", nullable = false )
	private PatientDetailsPOJO patient;
	
	// Visit Date
	
	@Column(unique = false, nullable = false)
	private Date visitDate;
	
	// Glass Prescription Details
	
	@Column(unique = false, nullable = true, length=10)
	private String sphDistLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String sphDistRight;
	
	@Column(unique = false, nullable = true, length=10)
	private String cylDistLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String cylDistRight;
	
	@Column(unique = false, nullable = true, length=3)
	private Integer axisDistLeft;
	
	@Column(unique = false, nullable = true, length=3)
	private Integer axisDistRight;
	
	@Column(unique = false, nullable = true, length=10)
	private String vaDistLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String vaDistRight;
	
	@Column(unique = false, nullable = true, length=10)
	private String sphNearLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String sphNearRight;
	
	@Column(unique = false, nullable = true, length=10)
	private String cylNearLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String cylNearRight;
	
	@Column(unique = false, nullable = true, length=3)
	private Integer axisNearLeft;
	
	@Column(unique = false, nullable = true, length=3)
	private Integer axisNearRight;
	
	@Column(unique = false, nullable = true, length=10)
	private String vaNearLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String vaNearRight;
	
	@Column(unique = false, nullable = true, length=100)
	private String remarks;
	
	// Findings Details
	
	@Column(unique = false, nullable = true, length=100)
	private String anteriorSeg;
	
	@Column(unique = false, nullable = true, length=100 )
	private String posteriorSeg;
	
	@Column(unique = false, nullable = true)
	private Integer iopRight;
	
	@Column(unique = false, nullable = true)
	private Integer iopLeft;
	
	// A-Scan Details
	
	@Column(unique = false, nullable = true)
	private Float keraK1;
	
	@Column(unique = false, nullable = true)
	private Float keraK2;
	
	@Column(unique = false, nullable = true)
	private Float axialLength;
	
	@Column(unique = false, nullable = true)
	private Float iolPower;
	
	@Column(unique = false, nullable = true, length=200)
	private String surgicalPlan;
	
	// Discharge Summary Details
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = false, nullable = true)
	private Date admissionDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = false, nullable = true)
	private Date surgeryDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = false, nullable = true)
	private Date dischargeDate;
	
	@Column(unique = false, nullable = true, length=200)
	private String diagnosis;
	
	@Column(unique = false, nullable = true, length=200)
	private String surgicalProc;
	
	@Column(unique = false, nullable = true, length=50)
	private String surgeon;
	
	@Column(unique = false, nullable = true, length=50)
	private String anaesthetist;
	
	@Column(unique = false, nullable = true, length=200)
	private String investigations;
	
	@Column(unique = false, nullable = true, length=3 )
	private Integer followUp;
	
	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER, orphanRemoval = true )
	@JoinColumn( name = "visitId", referencedColumnName = "visitId")
	private List<DrugDetailsPOJO> drugs = new ArrayList<DrugDetailsPOJO>();

	@Transient
	private String searchText;
	
	@Transient
	private String searchFilter;
	
	@Transient
	private String searchDateFrom;
	
	@Transient
	private String searchDateTo;
	
}
