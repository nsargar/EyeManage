package com.app.eyemanage.pojo;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
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
	private String sphNearLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String sphNearRight;

	@Column(unique = false, nullable = true, length=10)
	private String cylLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String cylRight;
	
	@Column(unique = false, nullable = true, length=3)
	private Integer axisLeft;
	
	@Column(unique = false, nullable = true, length=3)
	private Integer axisRight;
	
	@Column(unique = false, nullable = true, length=10)
	private String vaLeft;
	
	@Column(unique = false, nullable = true, length=10)
	private String vaRight;
	
	@Column(unique = false, nullable = true, length=100)
	private String remarks;
	
	// Findings Details
	
	@Column(unique = false, nullable = true, length=100)
	private String anteriorSeg;
	
	@Column(unique = false, nullable = true, length=100)
	private String posteriorSeg;
	
	@Column(unique = false, nullable = true)
	private Integer iop;
	
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
	
	@Column(unique = false, nullable = false)
	private Date admissionDate;
	
	@Column(unique = false, nullable = false)
	private Date surgeryDate;
	
	@Column(unique = false, nullable = false)
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
	
	@Column(unique = false, nullable = true, length=3)
	private Integer followUp;
	
	@Column(unique = false, nullable = true)
	private Float fees;
	
	@OneToMany( mappedBy = "visit" , cascade = CascadeType.ALL, orphanRemoval = true )
	@Setter(AccessLevel.NONE)
	private final Set<DrugDetailsPOJO> drugs = new HashSet<DrugDetailsPOJO>();

	// Getter for Drugs
	public Set<DrugDetailsPOJO> getDrugs() {
		return  Collections.unmodifiableSet(this.drugs);
	}

}
