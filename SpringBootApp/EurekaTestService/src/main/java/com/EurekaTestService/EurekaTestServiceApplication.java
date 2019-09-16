package com.EurekaTestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //this is an app that runs eureka... rest is pretty normal info, check the app.props
@SpringBootApplication
public class EurekaTestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTestServiceApplication.class, args);
	}

}
