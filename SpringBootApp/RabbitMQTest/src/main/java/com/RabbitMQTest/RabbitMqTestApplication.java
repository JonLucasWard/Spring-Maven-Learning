package com.RabbitMQTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;


@SpringBootApplication //this be a spring app
public class RabbitMqTestApplication {

	//name of the message queue exchange we want to access (outside rabbit server)
	static final String topicExchangeName = "spring-boot-exchange";
	
	//name of the queue we want this app to watch and subscribe to on the rabbit server
	static final String queueName = "spring-boot";
	
	//bean managed by spring boot, returns the queue we want to access
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
		//boolean if the queue is durable or not (survives existence of the app, if it shuts down, it starts over completely)
	}
	
	//bean managed by spring boot, returns new exchange we want to access
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}
	
	//and now we associate the queue with the exchange
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
		//foo.bar.# is a routing key, all messages that begin with foo.bar will be sent to the queue
	}
	
	//create a "container" which holds the listener and a connection factory that allows the app to connect to
	//the outside messaging queue
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(); //make a blank container
		container.setConnectionFactory(connectionFactory); //set the factory for it
		container.setQueueNames(queueName); //give it queues to listen for
		container.setMessageListener(listenerAdapter); //set listener that will do stuff with that information
		return container; //give back the container, it is now active on the app
	}
	
	//create an instance of Receiver and call the desired function when a message is received
	@Bean
	MessageListenerAdapter listernerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RabbitMqTestApplication.class, args);
	}

}
