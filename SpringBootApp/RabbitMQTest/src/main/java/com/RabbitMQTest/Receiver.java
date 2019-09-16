package com.RabbitMQTest;


import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

/*
 * Needed to actually "get" messages out of the messaging queue
 */

@Component // this be a component, searched for in the rest of the package to do things with it
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1); 
	//creates a sync block to prevent other threads from interrupting until latch hits 0
	
	//function that does something with message information 
	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		latch.countDown(); //indicates a message was received? Re-opens thread for new messages if 0
	}
	
	public CountDownLatch getLatch() {
		return latch; //returns current count and state of latch
	}
}
