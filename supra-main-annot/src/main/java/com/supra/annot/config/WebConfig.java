package com.supra.annot.config;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
@EnableWebMvc
@ComponentScan(basePackages = "com.supra.annot.*")
public class WebConfig extends WebMvcConfigurerAdapter implements WebApplicationInitializer{
	
	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		//System.out.println("called configureContentNegotiation");
		HashMap<String, MediaType> mediaTypes = new HashMap<>();
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		configurer
			.mediaTypes(mediaTypes)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.favorParameter(false)
			.favorPathExtension(true);
		super.configureContentNegotiation(configurer);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//System.out.println("called onStartup");
		
	}
	
	
	
}
