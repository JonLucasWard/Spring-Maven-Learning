package com.FeignClientTestGame1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@GetMapping("/")
	public String play() {
		return "This is game 1";
	}
}
