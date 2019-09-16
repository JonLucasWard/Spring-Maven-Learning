package com.JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //things here are SpringBoot related, works with a database
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Bean //managed by database
	// command line runner just starts console logging stuff when the app starts
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			//save a series of people objects into our temporary database
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			
			//just some logs
			log.info("Customers found with findAll():");
			log.info("---------------------");
			//findAll() returns an array of customers, for each, print that object
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			
			//1L means "1 Long", print that customer if it exists
			repository.findById(1L)
			//if customer exists, pass it's into into the following method
				.ifPresent(customer -> {
					log.info("Customer found with findById(1L):");
					log.info("-----------------------");
					log.info(customer.toString());
					log.info("");
				});
			
			//print list of all entities with last name Bauer
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("-----------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			//following comments are deprecated code I guess
			// for (Customer bauer : repository.findByLastName("Bauer")) {
						// 	log.info(bauer.toString());
						// }
			log.info("");
		};
	}

}
