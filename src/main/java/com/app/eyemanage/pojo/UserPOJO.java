package com.app.eyemanage.pojo;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.*;

import groovy.transform.EqualsAndHashCode;


@Entity
@Table(name="Users")
@Component

public class UserPOJO {
	private Integer userId;
	private String name;
	private String password;
	private String email;
	private String cnfPassword;
	private String secQuest;
	private String answer;
	
	public UserPOJO() {
		System.out.println("Def Ctor UserPOJO");
	}
	
	public UserPOJO(Integer userId, String name, String password, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	

	@Column(name = "userId", unique = true, nullable = false)
	@Id
	@SequenceGenerator( name="UserDetails_SEQ", sequenceName="UserDetails_SEQ", allocationSize=1 )
	@GeneratedValue( generator="UserDetails_SEQ",strategy=GenerationType.SEQUENCE )
	//@GeneratedValue()
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(length=30)
	@NotEmpty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=16)
	@NotEmpty
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=60)
	@Email
	@NotEmpty
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length=16)
	@NotEmpty
	@Transient
	public String getCnfPassword() {
		return cnfPassword;
	}

	public void setCnfPassword(String cnfPassword) {
		this.cnfPassword = cnfPassword;
	}
	
	@Column(length=100)
	public String getSecQuest() {
		return secQuest;
	}

	public void setSecQuest(String secQuest) {
		this.secQuest = secQuest;
	}
	
	@Column(length=30)
	@NotEmpty
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "UserPOJO [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
}
