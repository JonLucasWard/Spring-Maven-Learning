package com.example.hello;

//model for data to be used in app
public class Greeting {
	private final long id;
	private final String content;
	
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
}
