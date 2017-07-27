package com.app.eyemanage.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationConfig implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		/*try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    	String date = sdf.format(new Date());
	    	//System.setProperty("log4jfilename", "eyemanage_log_"+ date + ".log");
	    	System.setProperty("date", date);
	    	//System.out.println(System.getProperty("date"));
		} catch (Exception e) {
			System.out.println("Error Message : " + e.getMessage());
			//e.printStackTrace();
		} */
	}

}
