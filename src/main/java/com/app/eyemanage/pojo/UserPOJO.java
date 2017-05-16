package com.app.eyemanage.pojo;

import javax.persistence.*;
import org.springframework.stereotype.*;

@Entity
@Table(name="UserDetails")
@Component
//New line
public class UserPOJO {
	private Integer userId;
	private String name;
	private String password;
	private String email;
	
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
	
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=16)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=30)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserPOJO [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
}
