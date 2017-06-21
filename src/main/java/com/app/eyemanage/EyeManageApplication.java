package com.app.eyemanage;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class EyeManageApplication extends SpringBootServletInitializer {

	static final Logger logger = Logger.getLogger(EyeManageApplication.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EyeManageApplication.class);
    }

    public static void main(String[] args) throws Exception {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	String date = sdf.format(new Date());
    	System.setProperty("log4jfilename", "eyemanage_log_"+ date + ".log");
    	System.out.println(System.getProperty("log4jfilename"));
    	
    	SpringApplication.run(EyeManageApplication.class, args);
    }
    
}
