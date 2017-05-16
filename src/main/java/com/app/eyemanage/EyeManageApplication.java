package com.app.eyemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

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
