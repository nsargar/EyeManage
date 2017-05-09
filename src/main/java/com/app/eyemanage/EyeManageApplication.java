package com.app.eyemanage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.eyemanage.pojo.UserPOJO;
import com.app.eyemanage.service.UserService;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableJpaRepositories
@Configuration
public class EyeManageApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(EyeManageApplication.class, args);
	
		
//		user.save(new UserPOJO("Nilis08", "nilis", "voidprongzz", "ggfjyskjf.asdg@dhf.com"));
	}
	
/*	  @Bean
	    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	        return hemf.getSessionFactory();
	    }*/
}
