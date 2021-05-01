package com.cg.onlineadvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is starts up the Spring ApplicationContext
 * @author mohdansa
 */
@SpringBootApplication
public class OnlineAdvertisementSystemApiApplication {

	public static void main(String[] args) {
		/**
		 * It bootstraps a spring application as a stand-alone application.
		 * It creates an appropriate ApplicationContext instance and load beans.
		 * It also runs embedded Tomcat server in Spring web application.
		 */
		SpringApplication.run(OnlineAdvertisementSystemApiApplication.class, args);
		
	}
}
