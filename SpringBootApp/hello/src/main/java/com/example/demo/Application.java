package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // indicate start of spring boot app
public class Application {

		public static void main(String[] args) { //run the rest of the app and files associated in this package
			SpringApplication.run(Application.class, args);
		}
}
