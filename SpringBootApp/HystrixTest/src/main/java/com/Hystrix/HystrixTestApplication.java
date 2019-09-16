package com.Hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker //This app has Hystrix as part of it
@RestController //This app can accept HTTP calls to various paths
@SpringBootApplication //It be a Spring Bootie app
public class HystrixTestApplication {

	@Autowired //Bring in the BookService found elsewhere in this app, create an instance of it
	private BookService bookService;
	
	@Bean //bring in dependency from RestTemplate to be able to read HTTP calls
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@RequestMapping("/to-read") //when this port and url path is called, fire the command
	public String toRead() {
		return bookService.readingList(); //call the readingList function from bookService
	}

  public static void main(String[] args) {
    SpringApplication.run(HystrixTestApplication.class, args);
  }
}
