package com.ZuulTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.ZuulTest.filters.pre.SimpleFilter;

@EnableZuulProxy //this app acts as a "reverse" proxy, forwarding HTTP calls to other services and addresses
@SpringBootApplication //this app is a spring boot app and uses its libraries
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	//connect the filter class we made, to the main zuul portal
	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter(); //create an instance of the filter for zuul to use
	}
	
}
