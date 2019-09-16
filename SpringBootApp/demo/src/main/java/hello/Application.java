package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*adds a buncha stuff like:
 * @Configuration - tags class as source of bean definitions, things that communicate with database
 * @EnableAutoConfiguration - add beans based on classpath settings, other beans, and various property settings.
 * @ComponentScan, look for other components, configs, and services in this package to find controllers
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) { // launch application
		SpringApplication.run(Application.class, args);
	}
	
	@Bean // tracked by app
	//following will print out all "beans" that are a part of this application when it runs
	public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans given by Spring Boot:");
			
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}

//starter actuator is part of dependencies, it gives a LOT more endpoints that give information about the point if called
