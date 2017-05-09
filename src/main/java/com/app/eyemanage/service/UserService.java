package com.app.eyemanage.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.app.eyemanage.pojo.UserPOJO;

public interface UserService extends CrudRepository<UserPOJO, String>{
	public void addUser(UserPOJO user);
}
