package com.cycle.habeeb.springbootrestapi.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("hello-bean")
	public HelloBean helloBean() {
		return new HelloBean("Hello World");
	}
	
	@GetMapping("hello/path/{message}")
	public HelloBean helloPath(@PathVariable String message) {
		return new HelloBean(String.format("Hello Message, %s", message));
	}
}
