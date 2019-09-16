package com.HystrixBookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController //calls to this app can manage other url paths calls to it
@SpringBootApplication //dis be an app managed by spring boot
public class HystrixTestBookStoreApplication {

	@RequestMapping(value = "/recommended") //when a URL call to /recommended happens, trigger the function
	public String readingList() {
		return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixTestBookStoreApplication.class, args);
	}

}
