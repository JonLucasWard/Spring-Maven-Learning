package com.FeignClientTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;

@SpringBootApplication
@RestController
@EnableFeignClients
public class FeignClientTestApplication {

	@Autowired
	private FeignInterface feign;
	
	@RequestMapping("/")
	public String play() {
		return feign.play();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FeignClientTestApplication.class, args);
	}
	
	@FeignClient(name = "game", url = "http://localhost:8082")
	@Component
	public interface FeignInterface {
		@RequestMapping("/")
		public String play();
	}
}
