package com.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service //this class is a service for the rest of the package
public class BookService {

	//create an instance of the RestTemplate
	private final RestTemplate restTemplate;
	
	//create a function that accepts a rest template (from an incoming HTTP call) and apply it to the restTemplate made earlier
	public BookService(RestTemplate rest) {
		this.restTemplate = rest; // assign the http call into this variable
	}
	
	//The following function is managed by Hystrix, if it begins to fail, it will use the reliable method instead
	//to test that fallback works, run it WITHOUT the partner hystrix app turned on
	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		URI uri = URI.create("http://localhost:8090/recommended"); //make an instance of the defined URL
		return this.restTemplate.getForObject(uri, String.class); //call the URL, expect a string to come back from it
	}
	
	//the fallback method described earlier
	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}
}
