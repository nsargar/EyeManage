package com.app.eyemanage.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.app.eyemanage.pojo.UserPOJO;

@Service
public interface UserService extends CrudRepository<UserPOJO, String>{
	
}
