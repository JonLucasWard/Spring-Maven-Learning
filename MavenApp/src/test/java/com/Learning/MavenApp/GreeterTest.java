package com.Learning.MavenApp;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class GreeterTest {
	private Greeter greeter = new Greeter();
	
	@Test
	public void greeterSayHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}
}
