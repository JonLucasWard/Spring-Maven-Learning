package com.example.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// controls all calls to the /greeting address URL
@RestController
public class GreetingController {
	//template to be put into the function later, % can be anything
	private static final String template = "Hello, %s!";
	//makes numbers
	private final AtomicLong counter = new AtomicLong();
	
	//when /greeting is called, do the following
	//takes in name parameter and throws it into the template, else World is used
	@RequestMapping("/greeting")
	public Greeting Greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
}
