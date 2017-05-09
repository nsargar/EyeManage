package com.app.eyemanage.pojo;

import javax.persistence.*;

import org.springframework.stereotype.*;

@Entity
@Table(name="UserDetails")
@Component
public class UserPOJO {
	private String userId;
	private String name;
	private String password;
	private String email;
	
	public UserPOJO() {
		System.out.println("Def Ctor UserPOJO");
	}
	
	public UserPOJO(String userId, String name, String password, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	
	@Id
	@Column(length=10)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
