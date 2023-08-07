package com.wakawakavendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@RestController
public class ApplicationEntry {
	@Value("${spring.application.name}")
	private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationEntry.class, args);
	}
	
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
	
    @RequestMapping(value = "/")
    public String hello() {
      return "Hello World, welcome to wakawaka vendor api";
    }
   
    @RequestMapping(value = "/name")
    public String name() {
	   return name;
    }
   
}
