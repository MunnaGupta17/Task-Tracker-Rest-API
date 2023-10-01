package com.TaskTracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	@Override
	 public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	        .allowedOrigins("http://localhost:3000", "https://munnagupta17.github.io/Task-Tracker-Website/")
	        .allowedMethods("GET", "POST", "PUT", "DELETE")
	        .allowCredentials(true);
	}
	
	

}
