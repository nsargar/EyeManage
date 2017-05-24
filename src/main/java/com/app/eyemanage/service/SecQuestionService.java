package com.app.eyemanage.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.eyemanage.model.ForgotPassword;
import com.app.eyemanage.model.SecQuestions;

@Repository
public interface SecQuestionService {
	//select  s.id,s.question 
	@Query(value="from SecQuestions s")
	List<SecQuestions> findAllQues();
}
