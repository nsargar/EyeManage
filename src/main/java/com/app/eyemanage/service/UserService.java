package com.app.eyemanage.service;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;
import com.app.eyemanage.model.ForgotPassword;
import com.app.eyemanage.model.SecQuestions;
import com.app.eyemanage.pojo.UserPOJO;

@Repository
public interface UserService extends CrudRepository<UserPOJO, Integer>,LoginService,SecQuestionService{
	boolean add(UserPOJO userDetails);
	boolean forgotPassCheck(ForgotPassword forgotUser);
}