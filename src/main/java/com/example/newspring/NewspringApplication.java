package com.example.newspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NewspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewspringApplication.class, args);
	}
	@GetMapping(value = "/spring")
	public String welcome(){
		return "hello spring";
	}
    
	@GetMapping(value = "/testing")
	public String testing(){
		return "working";
	}
     @GetMapping(value = "/sample")
	public String sample(){
		return "working";
	}
}
