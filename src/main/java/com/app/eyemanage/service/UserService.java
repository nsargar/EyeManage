package com.app.eyemanage.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;
import com.app.eyemanage.pojo.UserPOJO;

@Repository
public interface UserService extends CrudRepository<UserPOJO, Integer>{
	
	@Query("from user_details u where u.user_id=:id and u.password=:password")
	Integer validateLogin( @Param("id") Integer id , @Param("password") String password);
}
