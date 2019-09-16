package com.ZuulTestBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* An example service for use in testing Zuul apps, refer to some other info in the application.properties file*/

@RestController //this app manages various url paths
@SpringBootApplication //main class to run through spring boot's libraries
public class BookApp {

	//the following happens when URL/available is entered by user
	@RequestMapping(value = "/available")
	public String available() {
		return "Spring in Action"; //just displays this string on the page
	}
	
	//as above but for URL/checked-out
	@RequestMapping(value = "/checked-out")
	public String checkedOut() {
		return "Spring Boot in Action";
	}
	
	//run the app as soon as this next section is compiled
	public static void main(String[] args) {
		SpringApplication.run(BookApp.class, args);
	}

}