package com.JPA;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//by extending CrudRepository, Spring Data does the rest of the implementation at run time
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	
	
}
