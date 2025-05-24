package com.tekpyramid.MovieRater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*SpringApplication.run(Class<?> primarySource, String... args) is called.
* SpringApplication is instantiated.
* Application environment is prepared using SpringApplicationRunListeners.
* ApplicationArguments are parsed from the provided command-line arguments.
* Application context is initialized.
* Autoconfiguration classes are applied.
* Log configurations are initialized.
* Application context refreshed.
8. Application started, and CommandLineRunner and ApplicationRunner beans are executed.
* Application is ready to handle requests.
* Application fully started.*/

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