package com.tekpyramid.MovieRater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRaterApplication.class, args); //ConfigurableApplicationContext
	}
}

/* @SpringBootApplication annotation is a convenience annotation
* It is a combination of @Configuration, @EnableAutoConfiguration and @ComponentScan
* This indicates primary configuration class
* It triggers autoconfigure and component scanning
* without this spring boot won't automatically set up the application context. */

/* SpringApplication.run(MovieRaterApplication.class, args);
* This line launches the spring boot application
* It creates application context,starts embedded server & performs scanning
* MovieRaterApplication.class tells spring which is the main configuration class
* args - forwards any command line arguments*/