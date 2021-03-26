package com.wipro.OnlineAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.wipro.OnlineAssessment.ServletInitializer;
@SpringBootApplication
public class OnlineAssessmentApplication extends ServletInitializer {
	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path","/OnlineAssessment");
		SpringApplication.run(OnlineAssessmentApplication.class, args);
	}
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(OnlineAssessmentApplication.class);
	 }
}