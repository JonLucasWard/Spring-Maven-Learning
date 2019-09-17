package com.FeignClientTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController //can accept html addresses
@EnableFeignClients //able to use clients thru feign
public class FeignClientTestApplication {
	@Autowired //create an instance of the app we want to work with
	Game client;

	@RequestMapping("/") //use following method when the request is called with / after the URL
	public String hello() {
		return client.play(); //use the play() method on the matching client app
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignClientTestApplication.class, args);
	}

	@FeignClient("Game") //connect to the "Game" named applications
	//notably! if there are multiple "games" on the service discovery, each ping will use a new service!
	interface Game { //interface on how to use the apps
		@RequestMapping(value = "/", method = GET) //how to access the main server
		String play();
	}
}