package com.cycle.habeeb.springbootrestapi.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

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
	
	//Internationalization I18n
	@GetMapping("/hello_internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", 
			required=false) Locale locale) {
		
		return messageSource.getMessage("good.morning.message", null, locale);
	}	
	@GetMapping("/hello_world_internationalized")
	public String helloWorldLocaleInternationalized() {
		
		return messageSource.getMessage(
				"good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
