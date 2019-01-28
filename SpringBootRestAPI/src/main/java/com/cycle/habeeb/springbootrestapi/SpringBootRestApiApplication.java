package com.cycle.habeeb.springbootrestapi;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/*
	 * Taking the whole code to application.properties as
	 * spring.messages.basename=messages
	 
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}
	*/
}

