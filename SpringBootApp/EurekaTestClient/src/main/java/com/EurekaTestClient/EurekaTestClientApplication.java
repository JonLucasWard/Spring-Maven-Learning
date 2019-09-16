package com.EurekaTestClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@EnableDiscoveryClient //this app can be found by Eureka, will attempt to connect with it
@SpringBootApplication // standard spring boot start indicator
public class EurekaTestClientApplication {

	public static void main(String[] args) { //run this class
		SpringApplication.run(EurekaTestClientApplication.class, args);
	}

}

@RestController //this class can manage different HTTP routes
class ServiceInstanceRestController {
	@Autowired //pull in information about DiscoveryClient from other packages
	private DiscoveryClient discoveryClient; //create an instance about the discovery client
	
	@RequestMapping("/service-instances/{applicationName}") // path to this app
	public List<ServiceInstance> serviceInstacesByApplicationName( //display a list of services by name as this app's main function
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
}
