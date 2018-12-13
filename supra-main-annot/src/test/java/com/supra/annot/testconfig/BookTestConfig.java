package com.supra.annot.testconfig;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.supra.annot.repository.ApplicationPropertyRepository;
@Configuration
@ComponentScan("com.supra")
public class BookTestConfig {

	
	@Autowired
	ApplicationPropertyRepository appPropRepository;
	
	
	
	@Autowired
    ServletContext servletContext;
  
   
    
    
    
   
}