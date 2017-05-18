package com.app.eyemanage.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;
import com.app.eyemanage.pojo.UserPOJO;

@Repository
public interface UserService extends CrudRepository<UserPOJO, Integer>,LoginService{
	boolean add(UserPOJO userDetails);
}
