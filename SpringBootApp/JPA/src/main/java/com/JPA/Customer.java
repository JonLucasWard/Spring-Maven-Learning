package com.JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //this is managed as a database object
public class Customer {
	@Id //primary key of the database
	@GeneratedValue(strategy=GenerationType.AUTO) //auto increments new ids, no further work needed
	private Long id;
	
	//the following 2 don't need Column annotations, the whole class is already an entity
	private String firstName;
	private String lastName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	protected Customer() {} //only packages internal to this can make customers directly
	
	public Customer(String firstName, String lastName) { //make a customer, ID is automatic
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override // change toString function
	public String toString() { //print the customer, % is filled in from instance's fields
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s']",
				id, firstName, lastName);
	}
}
