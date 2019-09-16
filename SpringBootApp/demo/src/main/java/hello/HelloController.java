package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

// the following indicates the class is to be used by Spring MVC for web requests
@RestController 
public class HelloController {
	@RequestMapping("/") // whenever there's just "/" at the end of the path to this app, this code runs
	public String index() { // the index method is called, it just returns text
		return "Greetings from Sping Boot!";
	}
}
